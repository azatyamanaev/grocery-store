package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.grocerystore.dto.InviteDto;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.services.InviteStudentService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class InviteStudentController {
    @Autowired
    private InviteStudentService inviteStudentService;

    @PostMapping("/api/inviteStudent")
    public ResponseEntity<?> inviteStudent(@AuthenticationPrincipal User user, InviteDto inviteDto, HttpServletRequest servletRequest) {
        inviteStudentService.inviteStudent(inviteDto, user, servletRequest.getHeader("referer"));
        return ResponseEntity.ok().body("Complete");
    }
}
