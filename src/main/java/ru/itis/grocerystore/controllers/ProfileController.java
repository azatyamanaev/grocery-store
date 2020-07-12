package ru.itis.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.grocerystore.security.details.UserDetailsImpl;
import ru.itis.grocerystore.services.ProfileService;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile/{id}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getProfilePage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        if (userDetails.getUser().getId() == id) {
            return new ModelAndView("redirect:/profile");
        }
        User user = profileService.getUserById(id);
        modelAndView.addObject()
        return modelAndView;
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getOwnProfilePage() {
        ModelAndView modelAndView = new ModelAndView();
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User user = userDetails.getUser();


    }
}
