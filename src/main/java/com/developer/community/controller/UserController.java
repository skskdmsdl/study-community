package com.developer.community.controller;

import com.developer.community.controller.request.UserJoinRequest;
import com.developer.community.controller.request.UserLoginRequest;
import com.developer.community.controller.response.Response;
import com.developer.community.controller.response.UserJoinResponse;
import com.developer.community.controller.response.UserLoginResponse;
import com.developer.community.model.User;
import com.developer.community.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String join() {
        return "user/join";
    }

    @ResponseBody
    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        // join
        User user = userService.join(request.getUserName(), request.getPassword());
        return Response.success(UserJoinResponse.fromUser(user));
    }

    @ResponseBody
    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request){
        String token = userService.login(request.getUserName(), request.getPassword());
        return Response.success(new UserLoginResponse(token));
    }
}
