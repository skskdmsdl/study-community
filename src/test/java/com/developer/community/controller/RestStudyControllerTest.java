package com.developer.community.controller;

import com.developer.community.controller.request.StudyCreateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("rest 컨트롤러")
@SpringBootTest
@AutoConfigureMockMvc
class RestStudyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    public void 스터디작성() throws Exception {
        String title = "title";
        String body = "body";
        Integer recruitment = 0;
        String subject = "선택안함";
        Integer onOffline = 0;
        Integer memberCount = 5;

//        mockMvc.perform(post("/studies/posts")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(objectMapper.writeValueAsBytes(new StudyCreateRequest(title, body, recruitment, subject, onOffline, memberCount)))
//                ).andDo(print())
//                .andExpect(status().isOk());

    }
}
