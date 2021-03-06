package ru.itis.grocerystore.services;

import ru.itis.grocerystore.models.Event;

import java.util.List;

public interface EventsService {
    List<Event> getAllEventsForUser(Long id);
    List<Event> getAllEvents();
    Event getEventByName(String name);
    void createEvent(Event event);
    void updateEvent(Event event);
    Event getEventById(Long id);
}
