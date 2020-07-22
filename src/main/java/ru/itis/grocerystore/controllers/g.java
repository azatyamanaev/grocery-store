package ru.itis.grocerystore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class g {

    @GetMapping("/g")
    public String g() {
        return "g";
    }
}
