package com.myproject.antaev.entity;

import com.myproject.antaev.rest.data_type.StatusTask;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskNumber;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity author;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity performer;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReleaseEntity release;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTask status;

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public UserEntity getPerformer() {
        return performer;
    }

    public void setPerformer(UserEntity performer) {
        this.performer = performer;
    }

    public ReleaseEntity getRelease() {
        return release;
    }

    public void setRelease(ReleaseEntity release) {
        this.release = release;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }
}
