package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.grocerystore.dto.InviteDto;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.InviteStudentService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InviteStudentController {
    @Autowired
    private InviteStudentService inviteStudentService;

    @PostMapping("/api/inviteStudent")
    public String inviteStudent(@AuthenticationPrincipal UserDetailsImpl user, InviteDto inviteDto, HttpServletRequest servletRequest) {
        String referer = servletRequest.getHeader("referer");
        inviteStudentService.inviteStudent(inviteDto, user.getUser(), referer);
        return "redirect:/profile/" + referer.substring(referer.lastIndexOf("/") + 1);
    }


}
