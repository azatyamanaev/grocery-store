package ru.itis.grocerystore.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.grocerystore.models.Event;
import ru.itis.grocerystore.repositories.EventsRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventsServiceTest {

    @MockBean
    private EventsRepository eventsRepository;
    @Autowired
    private EventsService eventsService;

    @Test
    public void getEventByIdTest() {
        given(this.eventsRepository.findById(any()))
                .willReturn(java.util.Optional.of(new Event(10L, "event")));
        Event event = eventsService.getEventById(10L);
        assert event.getId().equals(10L);
    }

    @Test
    public void getEventByName() {
        given(this.eventsRepository.findById(any()))
                .willReturn(java.util.Optional.of(new Event(10L, "event")));
        Event event = eventsService.getEventById(10L);
        assert event.getName().equals("event");
    }
}
