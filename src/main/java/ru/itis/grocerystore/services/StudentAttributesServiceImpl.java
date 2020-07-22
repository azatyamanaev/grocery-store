package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.models.WorkExperience;
import ru.itis.grocerystore.repositories.WorkExperienceRepository;

@Service
public class StudentAttributesServiceImpl implements StudentAttributesService{

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @Override
    public void addWorkExp(WorkExperience workExperience) {
        workExperienceRepository.save(workExperience);
    }
}
