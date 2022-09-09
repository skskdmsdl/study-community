package com.developer.community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/studies")
@Controller
@RequiredArgsConstructor
public class ViewStudyController {

    @GetMapping
    public String studies(ModelMap map, Authentication authentication) {

        map.addAttribute("studies", List.of());
        return "studies/index";
    }

    @GetMapping("/detail")
    public String detail(ModelMap map, Authentication authentication) {

        map.addAttribute("studies", List.of());
        return "studies/detail";
    }
}
