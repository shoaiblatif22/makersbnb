package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ContactUsController {
    @GetMapping("/contactus")
    public ModelAndView ContactUs() {
        ModelAndView modelAndView = new ModelAndView("/contactus");
        String emailAddress = "fakeEmailAddress@makers.com";
        modelAndView.addObject("emailAddress", emailAddress);
        return modelAndView;
    }


}
