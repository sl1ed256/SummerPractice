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
}
