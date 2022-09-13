package com.developer.community.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러")
@SpringBootTest
@AutoConfigureMockMvc
class ViewStudyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("[view][GET] 스터디 리스트 페이지 - 정상 호출")
    @Test
    public void 스터디페이지_정상호출() throws Exception {
        mockMvc.perform(get("/studies"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("studies/index"))    // view 이름 테스트
                .andExpect(model().attributeExists("studies"));
    }

    @Disabled("구현 중")   // 각 단위 method 별로 테스트 제외할 수 있음
    @DisplayName("[view][GET] 스터디 상세 페이지 - 정상 호출")
    @Test
    public void 스터디상세페이지_정상호출() throws Exception {
        mockMvc.perform(get("/studies/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("studies/detail"))
                .andExpect(model().attributeExists("study"))
                .andExpect(model().attributeExists("studyComments"));
    }

    @DisplayName("[view][GET] 스터디 작성 페이지 - 정상 호출")
    @Test
    public void 스터디작성페이지_정상호출() throws Exception {
        mockMvc.perform(get("/studies/write"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("studies/write"))    // view 이름 테스트
                .andExpect(model().attributeExists("studies"));
    }
}