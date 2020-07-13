package ru.itis.grocerystore.services;

public interface EmailService {
    void sendNotification(String subject, String text, String email);
}
