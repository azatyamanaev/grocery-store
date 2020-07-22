package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.grocerystore.models.Event;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.EventsService;

@Controller
@PreAuthorize("isAuthenticated()")
public class EventPageController {

    @Autowired
    private EventsService eventsService;

    @GetMapping("/event")
    public String getEventPage(@RequestParam("event_name") String name, Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("login", userDetails.getUser().getLogin());
        model.addAttribute("event", eventsService.getEventByName(name));
        return "event";
    }

    @PostMapping("/editEvent")
    public String editEvent(Authentication authentication, @RequestParam Long id, @RequestParam String name, @RequestParam String information, @RequestParam String link, Model model) {
        Event event = eventsService.getEventById(id);
        event.setName(name);
        event.setInformation(information);
        event.setLink(link);
        eventsService.updateEvent(event);
        model.addAttribute("event", event);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("login", userDetails.getUser().getLogin());
        return "event";
    }
}
