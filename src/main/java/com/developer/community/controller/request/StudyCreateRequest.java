package com.developer.community.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudyCreateRequest {
    private String title;
    private String body;
}
