package com.developer.community.controller;

import com.developer.community.controller.request.StudyCreateRequest;
import com.developer.community.controller.response.Response;
import com.developer.community.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/studies/posts")
@RestController
@RequiredArgsConstructor
public class RestStudyController {

    private final StudyService studyService;

    @PostMapping
    public Response<Void> create(@RequestBody StudyCreateRequest request, Authentication authentication) {
        studyService.create(request.getTitle(), request.getBody(), authentication.getName());
        return Response.success();
    }


}
