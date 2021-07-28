package com.myproject.antaev.entity;

import com.myproject.antaev.rest.data_type.StatusProject;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectNumber;

    @Column(nullable = false)
    private String nameOfProject;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CustomerEntity customer;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProject status;

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getNameOfProject() {
        return nameOfProject;
    }

    public void setNameOfProject(String nameOfProject) {
        this.nameOfProject = nameOfProject;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public StatusProject getStatus() {
        return status;
    }

    public void setStatus(StatusProject status) {
        this.status = status;
    }

}
