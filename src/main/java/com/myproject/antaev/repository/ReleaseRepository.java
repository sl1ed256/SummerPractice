package com.myproject.antaev.repository;

import com.myproject.antaev.entity.ReleaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseEntity, Integer> {
    List<ReleaseEntity> findAllByProjectId(int id);
}
