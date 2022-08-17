package com.developer.community.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러")
@WebMvcTest
class StudyControllerTest {

    private final MockMvc mvc;

    // test package의 생성자는 Autowired를 생략할 수 없음(생성자가 하나인 경우)
    public StudyControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 스터디 리스트 페이지 - 정상 호출")
    @Test
    public void 스터디페이지_정상호출() throws Exception {
        mvc.perform(get("/studies"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("studies"));
    }
}