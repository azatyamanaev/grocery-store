package ru.itis.grocerystore.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.grocerystore.dto.SignUpDto;
import ru.itis.grocerystore.dto.UserDto;
import ru.itis.grocerystore.services.SignUpService;

import javax.jws.WebParam;
import java.util.Optional;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getPage(Model model) {
        model.addAttribute("signUpDto", new SignUpDto());
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUp(SignUpDto signUpDto, BindingResult result, Model model) {
        if(!(result.hasErrors()))
            if (signUpService.signUp(signUpDto) != null)
                return "redirect:/signIn";
        model.addAttribute("signUpDto", signUpDto);
        return "signUp";
    }

    @GetMapping("/confirm/{code}")
    public String confirm(@PathVariable String code, Model model) {
        Optional<UserDto> userDto = signUpService.confirm(code);
        if (userDto.isPresent()) {
            model.addAttribute("message", "Ваша почта подтверждена!");
            return "signIn";
        } else {
            return "signUp";
        }
    }

    @PostMapping("/rest/signUp")
    @ResponseBody
    public ResponseEntity<String> signUp(@RequestBody SignUpDto signUpDto) {
        if (signUpService.signUp(signUpDto) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("You have successfully registered." +
                    "A confirmation email has arrived");
        }
        return ResponseEntity.badRequest().body("A user with this email exists");
    }

}
