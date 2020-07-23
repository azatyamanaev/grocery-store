package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.grocerystore.dto.StudentDto;
import ru.itis.grocerystore.models.*;
import ru.itis.grocerystore.security.jwt.details.UserDetailsImpl;
import ru.itis.grocerystore.services.ProfileService;
import ru.itis.grocerystore.services.UsersService;
import java.util.List;

@Controller
@PreAuthorize("isAuthenticated()")
public class EditProfileController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private ProfileService profileService;

    @GetMapping("/edit")
    public String getEditPage(Model model) {
        Role role;
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userDetails.getUser();
        try {
            //TODO: передать третьим параметром User и создавать view относительно того, кто запросил
            switch (profileService.getUserById(user.getId(), model)) {
                case COMPANY:
                    model.addAttribute("user", usersService.findCompany(user.getId()));
                    return ("editCompanyProfile");
                case STUDENT:
                    model.addAttribute("user", usersService.findStudent(user.getId()));
                    return ("editStudentProfile");
                case TEACHER:
                    model.addAttribute("user", usersService.findTeacher(user.getId()));
                    return ("editTeacherProfile");
                default:
                    break;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown role for ID: " + user.getId());
        }
        return "";
    }

    @PostMapping("/editStudent")
    public String editStudentProfile(StudentDto studentDto, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        List<RecommendationLetter> recommendationLetterList = usersService.findStudent(user.getId()).getRecommendationLetters();
        usersService.updateStudent(Student.builder()
                .id(user.getId())
                .login(studentDto.getLogin())
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .state(user.getState())
                .role(user.getRole())
                .lastName(studentDto.getLastName())
                .patronymic(studentDto.getPatronymic())
                .city(studentDto.getCity())
                .citizenship(studentDto.getCitizenship())
                .university(studentDto.getUniversity())
                .faculty(studentDto.getFaculty())
                .specialization(studentDto.getSpecialization())
                .skills(studentDto.getSkills())
                .languages(studentDto.getLanguages())
                .workExperiences(studentDto.getWorkExperiences())
                .gender(studentDto.getGender())
                .about(studentDto.getAbout())
                .linkToGit(studentDto.getLinkToGit())
                .confirmCode(user.getConfirmCode())
                .password(user.getPassword())
                .achievements(studentDto.getAchievements())
                .recommendationLetters(recommendationLetterList)
                .move(studentDto.getMove())
                .workSchedule(studentDto.getWorkSchedule())
                .birthDate(studentDto.getBirthDate())
                .educationalLevel(studentDto.getEducationalLevel())
                .educationEndYear(studentDto.getEducationEndYear())
                .build());
        return "redirect:/profile";
    }

    @PostMapping("/editCompany")
    public String editCompanyProfile(@RequestParam String login, @RequestParam String name, @RequestParam("link") String linkToSite, @RequestParam String about,
                                     @RequestParam String email, @RequestParam String number, @RequestParam String additionalInformation, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        usersService.updateCompany(Company.builder()
                .id(user.getId())
                .login(login)
                .email(email)
                .password(user.getPassword())
                .name(name)
                .role(user.getRole())
                .state(user.getState())
                .about(about)
                .linkToSite(linkToSite)
                .number(number)
                .additionalInformation(additionalInformation)
                .build());
        return "redirect:/profile";
    }

    @PostMapping("/editTeacher")
    public String editTeacherProfile(@RequestParam String login, @RequestParam String name, @RequestParam String lastName, @RequestParam String patronymic,
                                     @RequestParam String about, @RequestParam String position, @RequestParam String email, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        usersService.updateTeacher(Teacher.builder()
                .id(user.getId())
                .login(login)
                .email(user.getEmail())
                .password(user.getPassword())
                .state(user.getState())
                .role(user.getRole())
                .confirmCode(user.getConfirmCode())
                .name(name)
                .email(email)
                .lastName(lastName)
                .patronymic(patronymic)
                .about(about)
                .position(position)
                .build());
        return "redirect:/profile";
    }

    @PostMapping("/createNewPassword")
    public String changePassword(@RequestParam("inputPassword") String password, Authentication authentication) {
        usersService.changePassowrd(authentication, password);
        return "redirect:/profile";
    }

    @GetMapping("/createNewPassword")
    public String changePassword() {
        return "createNewPassword";
    }
}
