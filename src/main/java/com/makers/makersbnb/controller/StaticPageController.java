package com.makers.makersbnb.controller;

import com.makers.makersbnb.repositories.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StaticPageController {

    @Autowired
    private SpaceRepository spaceRepository;


    @GetMapping("/")
    public ModelAndView landingPage() {
        ModelAndView modelAndView = new ModelAndView("/LandingPage");
        Integer nSpaces = ((int) spaceRepository.count());
        Integer nSpacesBooked = 123;

        modelAndView.addObject("nSpaces", nSpaces);
        modelAndView.addObject("nSpacesBooked", nSpacesBooked);
        String[] reviews = new String[] {"Awesome", "Nice", "Perfect"};
        modelAndView.addObject("reviews", reviews);
        return modelAndView;
    }

}
