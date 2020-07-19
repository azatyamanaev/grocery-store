package ru.itis.grocerystore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.Skill;
import ru.itis.grocerystore.models.State;
import ru.itis.grocerystore.models.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class C {

    @GetMapping("/p")
    public String getProfilePage(Model model) {
        List<Skill> skills = new ArrayList<>();
        skills.add(Skill.builder().skill("Java").build());
        skills.add(Skill.builder().skill("React").build());
        model.addAttribute("student", Student.builder()
                .login("azyam")
                .state(State.CONFIRMED)
                .name("azat")
                .lastName("yam")
                .linkToGit("https://github.com/azatyamanaev")
                .role(Role.STUDENT)
                .skills(skills)
                .build());
        return "";
    }
}
