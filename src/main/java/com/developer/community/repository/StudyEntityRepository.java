package com.developer.community.repository;

import com.developer.community.model.entity.StudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyEntityRepository extends JpaRepository<StudyEntity, Integer> {
}
