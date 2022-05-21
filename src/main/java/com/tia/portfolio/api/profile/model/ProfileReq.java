package com.tia.portfolio.api.profile.model;

import lombok.Data;

@Data
public class ProfileReq {
    private String upno;
    private String subtitle;
    private String name;
    private String addr;
    private String addrDetail;
    private String resumeLink;
    private String privateResumeLink;
}
