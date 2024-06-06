package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TermsAndConditionsController {
    @GetMapping("/termsAndConditions")
    public ModelAndView TermsAndConditions() {
        ModelAndView modelAndView = new ModelAndView("/TermsAndConditions");
        String termsAndConditions = "Coming soon! In the meantime, please behave yourselves.";
        modelAndView.addObject("TermsAndConditions", termsAndConditions);
        return modelAndView;
    }
}
