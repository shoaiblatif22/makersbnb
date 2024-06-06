package com.makers.makersbnb.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WelcomeMessageController {
    @GetMapping("/WelcomeMessage")
    public ModelAndView Welcome(@AuthenticationPrincipal OAuth2User principal) {
        ModelAndView modelAndView = new ModelAndView("/WelcomeMessage");
        String WelcomeMessage = "Welcome to MakersBnB";
        modelAndView.addObject("WelcomeMessage", WelcomeMessage);
        if(principal != null) {
            modelAndView.addObject("username", principal.getAttribute("name"));
        } else {
            modelAndView.addObject("userName", "Guest");
        }

        return modelAndView;
    }

    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();


    @PostMapping("/logout")
    public String Logout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        this.logoutHandler.logout(request, response, authentication);
        return "redirect:/";
    }

}
