package ru.itis.grocerystore.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.grocerystore.dto.SignUpDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.services.SignUpService;

import java.util.Optional;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @PreAuthorize("permitAll()")
    @GetMapping(value = "/signUp")
    public String getSignUp(Model model) {
        model.addAttribute("signUpDto", new SignUpDto());
        return "signUp";
    }

    @PreAuthorize("permitAll()")
    @PostMapping(value = "/signUp")
    public String signUp(SignUpDto signUpDto, BindingResult result, Model model) {
        if(!(result.hasErrors()))
            if (signUpService.signUp(signUpDto) != null)
                return "redirect:/signIn";
        model.addAttribute("signUpDto", signUpDto);
        return "signUp";
    }

    @GetMapping("/confirm/{code}")
    public String confirm(@PathVariable String code) {
        Optional<UserDto> userDto = signUpService.confirm(code);
        if (userDto.isPresent()) {
            return "redirect:/signIn";
        } else {
            return "signUp";
        }
    }
}
