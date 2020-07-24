package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.repositories.*;

@Service
public class StudentAttributesServiceImpl implements StudentAttributesService{

    @Autowired
    private WorkExperienceRepository workExperienceRepository;
    @Autowired
    private LanguagesRepository languagesRepository;
    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private AchievementsRepository achievementsRepository;
    @Autowired
    private RecommendationLetterRepository letterRepository;

    @Override
    public void addWorkExp(WorkExperience workExperience) {
        workExperienceRepository.save(workExperience);
    }

    @Override
    public void addLanguage(Language language) {
        languagesRepository.save(language);
    }

    @Override
    public void addSkill(Skill skill) {
        skillsRepository.save(skill);
    }

    @Override
    public void addAchievement(Achievement achievement) {
        achievementsRepository.save(achievement);
    }

    @Override
    public void deleteWorkExp(Long id) {
        workExperienceRepository.deleteById(id);
    }

    @Override
    public void deleteLanguage(Long id) {
        languagesRepository.delete(id);
    }

    @Override
    public void deleteSkill(Long id) {
        skillsRepository.delete(id);
    }

    @Override
    public void deleteAchievement(Long id) {
        achievementsRepository.deleteById(id);
    }

    @Override
    public void addRecommendationLetter(RecommendationLetter recommendationLetter) {
        letterRepository.save(recommendationLetter);
    }

    @Override
    public void deleteRecommendationLetter(Long id) {
        letterRepository.deleteById(id);
    }
}
