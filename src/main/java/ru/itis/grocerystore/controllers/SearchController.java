package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.grocerystore.dto.FilterDto;
import ru.itis.grocerystore.dto.StudentSearchDto;
import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Student;
import ru.itis.grocerystore.services.SearchService;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/search")
    public @ResponseBody ResponseEntity<List<StudentSearchDto>> getStudentsByTags(FilterDto filterDto) {
        return ResponseEntity.ok(searchService.getStudentsByTags(filterDto));
    }

//    @PreAuthorize("isAuthenticated()")
//    @PostMapping("/search")
//    public String getByTags(FilterDto filterDto, Model model) {
//        List<Student> students = searchService.getStudentsByTags(filterDto);
//        model.addAttribute("students", students);
//        return "search";
//    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/search")
    public String getSearchPage(Model model) {
        searchService.getAllTags(model);
        return "search";
    }
}
