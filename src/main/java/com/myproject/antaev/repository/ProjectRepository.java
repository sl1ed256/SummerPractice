package com.myproject.antaev.repository;

import com.myproject.antaev.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {
    @Query(value = "select p from ProjectEntity p " +
            "where p.projectNumber = (select r.project.projectNumber from ReleaseEntity r " +
            "where r.releaseVersion = (select t.release.releaseVersion from TaskEntity t " +
            "where t.taskNumber = :taskId))")
    ProjectEntity getProjectByTask(Long taskId);
}
