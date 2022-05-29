package com.tia.portfolio.api.profile.model;

import lombok.Data;

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
