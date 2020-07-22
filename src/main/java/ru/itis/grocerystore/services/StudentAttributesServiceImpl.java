package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.models.Achievement;
import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Skill;
import ru.itis.grocerystore.models.WorkExperience;
import ru.itis.grocerystore.repositories.AchievementsRepository;
import ru.itis.grocerystore.repositories.LanguagesRepository;
import ru.itis.grocerystore.repositories.SkillsRepository;
import ru.itis.grocerystore.repositories.WorkExperienceRepository;

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
    public Long findIdOfSkill(String skill, Long studentId) {
        return skillsRepository.findIdOfSkill(skill, studentId);
    }

    @Override
    public Long findIdOfLanguage(String language, Long studentId) {
        return languagesRepository.findIdOfLanguage(language, studentId);
    }
}
