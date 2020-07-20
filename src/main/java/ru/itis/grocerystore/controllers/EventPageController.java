package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.EventsService;

@Controller
@PreAuthorize("isAuthenticated()")
public class EventPageController {

    @Autowired
    private EventsService eventsService;

    @GetMapping("/event")
    public String getEventPage(@RequestParam("event_name") String name, Model model, Authentication authentication) {
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("login", user.getUser().getLogin());
        model.addAttribute(eventsService.getEventByName(name));
        return "event";
    }
}