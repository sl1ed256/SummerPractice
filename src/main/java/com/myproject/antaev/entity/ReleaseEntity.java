package com.myproject.antaev.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import java.util.Date;

@Entity
@Table(name = "release")
public class ReleaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int releaseVersion;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "stopDate")
    private Date stopDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProjectEntity project;

    public int getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(int releaseVersion) {
        this.releaseVersion = releaseVersion;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }
}
