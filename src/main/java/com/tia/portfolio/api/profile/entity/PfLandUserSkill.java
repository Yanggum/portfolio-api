package com.tia.portfolio.api.profile.entity;

import javax.persistence.*;

@Entity
@Table(name = "pf_land_user_skills")
public class PfLandUserSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "SKL_NO", nullable = false)
    private Integer id;

    @Column(name = "UPNO", nullable = false)
    private Integer upno;

    @Column(name = "SKL_NAME", nullable = false, length = 30)
    private String sklName;

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

    public String getSklName() {
        return sklName;
    }

    public void setSklName(String sklName) {
        this.sklName = sklName;
    }

}