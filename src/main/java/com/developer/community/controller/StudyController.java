package com.developer.community.controller;

import com.developer.community.controller.request.StudyCreateRequest;
import com.developer.community.controller.response.Response;
import com.developer.community.service.StudyService;
import com.developer.community.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/studies")
@Controller
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @GetMapping
    public String studies(ModelMap map, Authentication authentication) {

        map.addAttribute("studies", List.of());
        return "studies/index";
    }

    @PostMapping
    public Response<Void> create(@RequestBody StudyCreateRequest request, Authentication authentication) {
        studyService.create(request.getTitle(), request.getBody(), authentication.getName());
        return Response.success();
    }


}
