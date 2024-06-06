package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StaffController {
    @GetMapping("/team")
    public ModelAndView team() {
        ModelAndView modelAndView = new ModelAndView("/team");
        String[] membersOfStaff = new String[] {"Toby", "Katerina", "Sandy"};
        modelAndView.addObject("membersOfStaff", membersOfStaff);
        return modelAndView;
    }
}
