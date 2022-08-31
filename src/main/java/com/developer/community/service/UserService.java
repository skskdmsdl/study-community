package com.developer.community.service;

import com.developer.community.exception.CommunityApplicationException;
import com.developer.community.exception.ErrorCode;
import com.developer.community.model.User;
import com.developer.community.model.entity.UserEntity;
import com.developer.community.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public User join(String userName, String password) {
        // 회원가입하려는 userName으로 user가 있는지 확인
        userEntityRepository.findByUserName(userName).ifPresent(it -> {
            throw new CommunityApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s is duplicated", userName));
        });
        
        // 회원가입 진행 = user를 등록
        UserEntity userEntity = userEntityRepository.save(UserEntity.of(userName, encoder.encode(password)));
        
        return User.fromEntity(userEntity);
    }
    public String login(String userName, String password) {
        // 회원가입 여부 체크(값이 있는 경우 userEntity를 받아오고, 없는 경우 exception throw)
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new CommunityApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));

        // 비밀번호 체크
        if(!userEntity.getPassword().equals(password)) {
            throw new CommunityApplicationException(ErrorCode.INVALID_PASSWORD, "");
        }

        // 토큰 생성

        return "";
    }
}
