package ru.itis.grocerystore.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;

@Controller
public class RootController {

    @GetMapping("/")
    public String getRootPage(Model model, Authentication authentication) {
        model.addAttribute("title", "Main Page");
        UserDetailsImpl user;
        model.addAttribute("auth", false);
        if (authentication != null) {
            user = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("auth", true);
        }

        return "index";
    }
}
