package com.developer.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/studies")
@Controller
public class StudyController {

    @GetMapping
    public String studies(ModelMap map) {
        map.addAttribute("studies", List.of());
        return "studies/index";
    }

}
