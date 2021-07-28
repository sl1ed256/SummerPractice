package com.myproject.antaev.repository;

import com.myproject.antaev.entity.ReleaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseEntity, Integer> {
}
