package ru.itis.grocerystore.services;

import org.springframework.ui.Model;
import ru.itis.grocerystore.dto.FilterDto;
import ru.itis.grocerystore.dto.StudentSearchDto;

import java.util.List;

public interface SearchService {
    void getAllTags(Model model);

    List<StudentSearchDto> getStudentsByTags(FilterDto filterDto);
}
