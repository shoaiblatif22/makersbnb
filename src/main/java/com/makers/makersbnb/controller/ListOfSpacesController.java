package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repositories.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
public class ListOfSpacesController {
    @Autowired
    private SpaceRepository spaceRepository;

    @GetMapping("/ListOfSpaces")
    public ModelAndView index(@AuthenticationPrincipal OAuth2User principal) {

        // getAttributes
        Map attributes = principal.getAttributes();
        // they will then be printed when you go to "/spaces"
        System.out.println(attributes);

        Iterable<Space> spaces = spaceRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("ListOfSpaces");
        modelAndView.addObject("listOfSpaces", spaces);
        return modelAndView;
    }


//    @GetMapping("/ListOfSpaces")
//    public ModelAndView spaces() {
//        ModelAndView modelAndView = new ModelAndView("/ListOfSpaces");
//        Iterable<Space> listOfSpaces = spaceRepository.findAll();
//        modelAndView.addObject("listOfSpaces", listOfSpaces);
//        return modelAndView;



    @GetMapping("/spaces/new")
    public ModelAndView newSpaceForm() {
        // this is the space referred to in th:object (look back at the form code)
        Space space = new Space();
        ModelAndView newSpaceForm = new ModelAndView("/Form");
        newSpaceForm.addObject("space", space);
        return newSpaceForm;
    }


    @PostMapping("/ListOfSpaces")
// Spring Boot uses the form data to create an instance of space
// which is then passed in as an arg here
    public RedirectView create(Space space) {
        spaceRepository.save(space);
        // assumes you already created a method to handle `GET "/spaces"`
        return new RedirectView("/ListOfSpaces");
    }






}
