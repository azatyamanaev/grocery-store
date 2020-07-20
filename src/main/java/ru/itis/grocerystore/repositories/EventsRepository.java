package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.grocerystore.models.Event;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Long> {
    //JPQL
    @Query("select e from Event e left join users u on e.user.id = u.id where u.id = :userId")
    List<Event> findAllEventsForUser(@Param("userId") Long userId);
    //JPQL
    @Query("select e from Event e where e.name = :eventName")
    Event findEventByName(@Param("eventName") String eventName);
}
