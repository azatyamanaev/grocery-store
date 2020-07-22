package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Event;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Event, Long> {
    //JPQL
    @Query("select e from Event e left join users u on e.user.id = u.id where u.id = :userId")
    List<Event> findAllEventsForUser(@Param("userId") Long userId);
    //JPQL
    @Query("select e from Event e where e.name = :eventName")
    Event findEventByName(@Param("eventName") String eventName);
    //JPQL
    @Modifying
    @Query("update Event e set e.host = ?1, e.information = ?2, e.link = ?3, e.name = ?4 where e.id = ?5")
    void updateEvent(String host, String information, String link, String name, Long id);
}
