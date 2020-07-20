package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.models.Event;
import ru.itis.grocerystore.repositories.EventsRepository;

import java.util.List;

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
}
