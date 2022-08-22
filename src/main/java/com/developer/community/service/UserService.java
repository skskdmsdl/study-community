package com.developer.community.service;

import com.developer.community.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User join() {
        return new User();
    }
}
