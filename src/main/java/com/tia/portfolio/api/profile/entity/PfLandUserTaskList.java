package com.tia.portfolio.api.profile.entity;

import javax.persistence.*;

@Entity
@Table(name = "pf_land_user_task_list")
public class PfLandUserTaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "TKNO", nullable = false)
    private Integer id;

    @Column(name = "UPNO", nullable = false)
    private Integer upno;

    @Column(name = "TASK_DESC", nullable = false, length = 250)
    private String taskDesc;

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

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

}