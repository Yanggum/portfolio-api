package com.tia.portfolio.api.profile.entity;

import javax.persistence.*;

@Entity
@Table(name = "pf_land_user_project_list")
public class PfLandUserProjectList {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "UPL_NO", nullable = false)
    private Integer id;

    @Column(name = "UPNO", nullable = false)
    private Integer upno;

    @Column(name = "PL_TYPE", nullable = false)
    private Character plType;

    @Column(name = "PROJECT_LINK", length = 2084)
    private String projectLink;

    @Column(name = "PROJECT_NAME", nullable = false, length = 30)
    private String projectName;

    @Column(name = "PROJECT_DESC", nullable = false, length = 250)
    private String projectDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUpno() {
        return upno;
    }

    public void setUpno(Integer upno) {
        this.upno = upno;
    }

    public Character getPlType() {
        return plType;
    }

    public void setPlType(Character plType) {
        this.plType = plType;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

}