package com.developer.community.controller;

import com.developer.community.controller.request.UserJoinRequest;
import com.developer.community.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String join() {
        return "user/join";
    }

    @PostMapping("/join")
    public void join(@RequestBody UserJoinRequest request) {
        // join
        userService.join();
    }
}
