package ru.itis.grocerystore.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.grocerystore.models.User;

@Controller
public class RootController {

    @GetMapping("/")
    public String getRootPage(Model model, Authentication authentication) {
        model.addAttribute("title", "Main Page");
        User user;
        model.addAttribute("auth", false);
        if (authentication != null) {
            user = (User) authentication.getPrincipal();
            model.addAttribute("auth", true);
        }

        return "index";
    }
}
