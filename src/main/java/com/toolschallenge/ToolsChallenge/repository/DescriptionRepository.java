package com.toolschallenge.ToolsChallenge.repository;

import com.toolschallenge.ToolsChallenge.model.entitys.DescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository  extends JpaRepository<DescriptionEntity, Long> {
}
