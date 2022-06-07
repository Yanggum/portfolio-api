package com.tia.portfolio.api.profile.entity;

import javax.persistence.*;

@Entity
@Table(name = "pf_land_user_profile")
public class PfLandUserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "UPNO", nullable = false)
    private Integer id;

    @Column(name = "SUBTITLE", length = 100)
    private String subtitle;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @Column(name = "RESUME_LINK", length = 2084)
    private String resumeLink;

    @Column(name = "JOB", nullable = false, length = 30)
    private String job;

    @Column(name = "CAREER_DESC", nullable = false, length = 200)
    private String careerDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCareerDesc() {
        return careerDesc;
    }

    public void setCareerDesc(String careerDesc) {
        this.careerDesc = careerDesc;
    }

}