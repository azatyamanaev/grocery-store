package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.dto.SignInDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.services.SignInService;

import java.util.Optional;

@Controller
public class SignInController {
    @Autowired
    private SignInService signInService;

    @PreAuthorize("permitAll()")
    @GetMapping("/signIn")
    public ModelAndView getSignPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signIn");
        return modelAndView;
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/signIn")
    public ModelAndView signIn(SignInDto signInDto) {
        Optional<UserDto> userDto = signInService.signIn(signInDto);
        ModelAndView modelAndView = new ModelAndView();
        if (userDto.isPresent()) {
            modelAndView.setViewName("redirect:/profile");
        } else {
            modelAndView.addObject("errors", "Some troubles with Email/Pass.");
            modelAndView.setViewName("signIn");
        }
        return modelAndView;
    }
}
