package com.developer.community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ViewUserController {

    @GetMapping("/join")
    public String join() {
        return "user/join";
    }

}
