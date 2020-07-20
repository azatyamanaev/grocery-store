package ru.itis.grocerystore.services;


import ru.itis.grocerystore.dto.InviteDto;
import ru.itis.grocerystore.models.User;

public interface InviteStudentService {
    void inviteStudent(InviteDto inviteDto, User user, String referer);
}
