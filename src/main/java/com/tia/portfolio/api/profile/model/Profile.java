package com.tia.portfolio.api.profile.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Profile {
    private String upno;
    private String subtitle;
    private String name;
    private String addr;
    private String addrDetail;
    private String resumeLink;
    private String privateResumeLink;
    private Integer pageNum;
    private Integer pageSize;
}
