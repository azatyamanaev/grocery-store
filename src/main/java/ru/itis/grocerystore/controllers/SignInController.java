package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.dto.SignInDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.services.AuthService;

import java.util.Optional;

@Controller
public class SignInController {
    @Autowired
    private AuthService authService;

//    @PreAuthorize("permitAll()")
//    @GetMapping("/signIn")
//    public ModelAndView getSignPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("signIn");
//        return modelAndView;
//    }

    @GetMapping("/signIn")
    public String getPage() {
        return "signIn";
    }

    @PostMapping("/signIn")
    public ModelAndView signIn(SignInDto signInDto, Model model) {
        Optional<UserDto> userDto = authService.signIn(signInDto);
        ModelAndView modelAndView = new ModelAndView();

        if (userDto.isPresent()) {
            modelAndView.setViewName("redirect:/search");
        } else {
            modelAndView.addObject("message", "Some troubles with Email/Pass.");
            modelAndView.setViewName("signIn");
        }
        return modelAndView;
    }
}
