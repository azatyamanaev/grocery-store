package ru.itis.grocerystore;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.grocerystore.repositories.StudentsRepository;

@SpringBootApplication
public class GroceryStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroceryStoreApplication.class, args);
    }
}
