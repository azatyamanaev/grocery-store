package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.grocerystore.dto.PasswordDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.ChangePasswordService;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Optional;

@Controller
public class ResetPasswordController {
    @Autowired
    private ChangePasswordService changePasswordService;

    @Autowired
    private MessageSource messages;

    @PostMapping("/user/resetPassword")
    @ResponseBody
    public GenericResponse resetPassword(HttpServletRequest request,
                                         @RequestParam("email") String userEmail) {
        Optional<UserDto> optionalUserDto = changePasswordService.findByEmail(userEmail);
        if (!optionalUserDto.isPresent()) {
            throw new UsernameNotFoundException("");
        }
        UserDto user = optionalUserDto.get();
        changePasswordService.createPasswordResetTokenForUser(user);
        return new GenericResponse(messages.getMessage("message.resetPasswordEmail", null,
                        request.getLocale()));
    }
    @GetMapping("/user/changePassword")
    public String showChangePasswordPage(Locale locale, Model model,
                                         @RequestParam("id") long id, @RequestParam("token") String token) {
        String result = changePasswordService.validatePasswordResetToken(id, token);
        if (result != null) {
            model.addAttribute("message",
                    messages.getMessage("auth.message." + result, null, locale));
            return "redirect:/login?lang=" + locale.getLanguage();
        }
        return "redirect:/updatePassword.html?lang=" + locale.getLanguage();
    }

    @PostMapping("/user/savePassword")
    @ResponseBody
    public GenericResponse savePassword(Locale locale, PasswordDto passwordDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        changePasswordService.changeUserPassword(userDetails.getUser(), passwordDto.getNewPassword());
        return new GenericResponse(
                messages.getMessage("message.resetPasswordSuc", null, locale));
    }
}
