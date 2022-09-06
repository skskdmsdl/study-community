package com.developer.community.controller;

import com.developer.community.controller.request.UserJoinRequest;
import com.developer.community.controller.request.UserLoginRequest;
import com.developer.community.controller.response.Response;
import com.developer.community.controller.response.UserJoinResponse;
import com.developer.community.controller.response.UserLoginResponse;
import com.developer.community.model.User;
import com.developer.community.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class RestUserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        // join
        User user = userService.join(request.getUserName(), request.getPassword());
        return Response.success(UserJoinResponse.fromUser(user));
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestBody UserLoginRequest request){
        ModelAndView mav = new ModelAndView();
        String token = userService.login(request.getUserName(), request.getPassword());
        Response.success(new UserLoginResponse(token));

        mav.addObject("token", token);
        mav.setViewName("redirect:/studies");
        return mav;
    }

//    @PostMapping("/login")
//    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request){
//        String token = userService.login(request.getUserName(), request.getPassword());
//        return Response.success(new UserLoginResponse(token));
//    }
}
