package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.grocerystore.services.EventsService;

@Controller
@PreAuthorize("isAuthenticated()")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping("/events")
    public String getEventsPage(Model model, Authentication authentication) {
        model.addAttribute("events", eventsService.getAllEvents());
        return "events";
    }
}
