package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.itis.grocerystore.dto.FilterDto;
import ru.itis.grocerystore.dto.StudentSearchDto;
import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Skill;
import ru.itis.grocerystore.models.Student;
import ru.itis.grocerystore.repositories.LanguagesRepository;
import ru.itis.grocerystore.repositories.SkillsRepository;
import ru.itis.grocerystore.repositories.StudentsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private LanguagesRepository languagesRepository;


    @Autowired
    private SkillsRepository skillsRepository;


    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public void getAllTags(Model model) {
        model.addAttribute("languages", languagesRepository.findAll());
        model.addAttribute("skills", skillsRepository.findAll());
    }

    @Override
    public List<StudentSearchDto> getStudentsByTags(FilterDto filterDto) {
        List<Student> students = studentsRepository
                .findAllTo(Skill.fromStringToSkill(filterDto.getSkills()),
                        Language.fromStringToLanguage(filterDto.getLanguages()));
        List<StudentSearchDto> studentSearchDtos = new ArrayList<>();
        for (Student student: students)
            studentSearchDtos.add(StudentSearchDto.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .lastName(student.getLastName())
                    .languages(student.getLanguages())
                    .skills(student.getSkills()).build());
        return studentSearchDtos;
    }
}
