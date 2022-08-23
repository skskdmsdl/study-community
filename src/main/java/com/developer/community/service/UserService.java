package com.developer.community.service;

import com.developer.community.exception.CommunityApplicationException;
import com.developer.community.model.User;
import com.developer.community.model.entity.UserEntity;
import com.developer.community.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;

    public User join(String userName, String password) {
        // 회원가입하려는 userName으로 user가 있는지 확인
        Optional<UserEntity> userEntity = userEntityRepository.findByUserName(userName);
        
        // 회원가입 진행 = user를 등록
        userEntityRepository.save(new UserEntity());
        
        return new User();
    }
    public String login(String userName, String password) {
        // 회원가입 여부 체크(값이 있는 경우 userEntity를 받아오고, 없는 경우 exception throw)
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new CommunityApplicationException());

        // 비밀번호 체크
        if(!userEntity.getPassword().equals(password)) {
            throw new CommunityApplicationException();
        }

        // 토큰 생성

        return "";
    }
}
