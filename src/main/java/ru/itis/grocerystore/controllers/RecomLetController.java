package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.grocerystore.models.RecommendationLetter;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.StudentAttributesService;
import ru.itis.grocerystore.services.UsersService;

@Controller
public class RecomLetController {

    @Autowired
    private StudentAttributesService service;
    @Autowired
    private UsersService usersService;

    @PostMapping("/writeRecomLet")
    public String writeRecomLet(String text, Authentication authentication, @RequestParam("studentId") Long id) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        RecommendationLetter letter = RecommendationLetter.builder()
                .text(text)
                .author(user.getLogin())
                .student(usersService.findStudent(id))
                .build();
        service.addRecommendationLetter(letter);
        return "redirect:/profile/" + id;
    }

    @PostMapping("/deleteRecomLet")
    @ResponseBody
    public ResponseEntity<Object> deleteRecomLet(Long id) {
        service.deleteRecommendationLetter(id);
        return ResponseEntity.ok("ok");
    }
}
