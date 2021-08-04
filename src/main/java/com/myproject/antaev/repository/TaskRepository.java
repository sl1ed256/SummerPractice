package com.myproject.antaev.repository;

import com.myproject.antaev.entity.TaskEntity;
import com.myproject.antaev.rest.dataType.StatusTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    //количество задач проекта в статусе
    @Query(value = "select count(p.id) from TaskEntity t " +
            "join t.release r " +
            "join r.project p " +
            "where p.id = :id and " +
            "t.status != :status")
    Long countTasksInProcessByProjectId(int id, StatusTask status);
}
