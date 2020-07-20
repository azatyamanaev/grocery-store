package ru.itis.grocerystore.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.dto.InviteDto;
import ru.itis.grocerystore.models.Student;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.repositories.StudentsRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class InviteStudentServiceImpl implements InviteStudentService {
    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private MessageConvertorService messageConvertorService;

    @Override
    public void inviteStudent(InviteDto inviteDto, User user, String referer) {
        Long studentId = Long.valueOf(referer.substring(referer.lastIndexOf("/") + 1));
        Optional<Student> studentOptional = studentsRepository.find(studentId);
        if (studentOptional.isPresent()) {
            Map<String, String> map = new HashMap<>();
            map.put("link", "http://localhost:8080/profile/ " + user.getId());
            map.put("name", user.getName());
            map.put("workType", inviteDto.getType().getName());
            map.put("message", inviteDto.getMessage());
            map.put("date", inviteDto.getStart());
            map.put("email", user.getEmail());
            map.put("role", user.getRole().toString());
            String text = messageConvertorService.inviteToFtl(map);
            emailService.sendNotification("Вас пригласили на работу!" , text, studentOptional.get().getEmail());
        } else throw new UsernameNotFoundException("No student with this id");
    }
}
