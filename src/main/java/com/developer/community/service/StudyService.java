package com.developer.community.service;

import com.developer.community.exception.CommunityApplicationException;
import com.developer.community.exception.ErrorCode;
import com.developer.community.model.entity.StudyEntity;
import com.developer.community.model.entity.UserEntity;
import com.developer.community.repository.StudyEntityRepository;
import com.developer.community.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyEntityRepository studyEntityRepository;
    private final UserEntityRepository userEntityRepository;

    @Transactional
    public void create(String title, String body, String userName) {
        // user find
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new CommunityApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));

        // study post save
        StudyEntity saved = studyEntityRepository.save(StudyEntity.of(title, body, userEntity));
    }


}
