package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.models.Event;
import ru.itis.grocerystore.repositories.EventsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventsServiceImpl implements EventsService {


    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public List<Event> getAllEventsForUser(Long id) {
        return eventsRepository.findAllEventsForUser(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventsRepository.findAll();
    }

    @Override
    public Event getEventByName(String name) {
        return eventsRepository.findEventByName(name);
    }

    @Override
    public void createEvent(Event event) {
        eventsRepository.save(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventsRepository.saveAndFlush(event);
    }

    @Override
    public Event getEventById(Long id) {
        Optional<Event> eventOptional = eventsRepository.findById(id);
        if (eventOptional.isPresent()) {
            return eventOptional.get();
        } else throw new IllegalStateException("Event is not present");
    }
}
