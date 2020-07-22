package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.grocerystore.models.Event;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.EventsService;

@Controller

public class EventsController {

    @Autowired
    private EventsService eventsService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/events")
    public String getEventsPage(Model model, Authentication authentication) {
        model.addAttribute("events", eventsService.getAllEvents());
        return "events";
    }

    @PreAuthorize("hasAuthority('COMPANY') || hasAuthority('TEACHER')")
    @PostMapping("/createEvent")
    public String createEvent(@RequestParam("name") String name, @RequestParam("information") String description, @RequestParam("link") String link, Authentication authentication) {
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        eventsService.createEvent(Event.builder()
                .host(user.getUser().getLogin())
                .name(name)
                .user(user.getUser())
                .information(description)
                .link(link)
                .build());
        return "redirect:/event?event_name=" + name;
    }
}
