package com.developer.community.controller;

import org.junit.jupiter.api.Disabled;
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
                .andExpect(view().name("studies/index"))    // view 이름 테스트
                .andExpect(model().attributeExists("studies"));
    }

    @Disabled("구현 중")   // 각 단위 method 별로 테스트 제외할 수 있음
    @DisplayName("[view][GET] 스터디 상세 페이지 - 정상 호출")
    @Test
    public void 스터디상세페이지_정상호출() throws Exception {
        mvc.perform(get("/studies/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("studies/detail"))
                .andExpect(model().attributeExists("study"))
                .andExpect(model().attributeExists("studyComments"));
    }
}