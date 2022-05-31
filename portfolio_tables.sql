create table pf_land_user_profile
(
    UPNO        int auto_increment comment '프로필 고유값'
        primary key,
    SUBTITLE    varchar(100) charset utf8  null comment '서브 타이틀',
    NAME        varchar(30) charset utf8   not null comment '이름',
    RESUME_LINK varchar(2084) charset utf8 null comment '이력서 링크',
    JOB         varchar(30)                not null comment '직업',
    CAREER_DESC varchar(200)               not null comment '이력 설명',
    constraint pf_land_user_profile_UPNO_uindex
        unique (UPNO)
);

create table pf_land_user_project_list
(
    UPL_NO       int auto_increment comment '프로젝트 리스트 고유값'
        primary key,
    UPNO         int              not null comment '프로필 테이블 고유값',
    PL_TYPE      char default 'L' not null comment '프로젝트 항목 타입(L:링크, T:텍스트)',
    PROJECT_LINK varchar(2084)    null comment '프로젝트 링크',
    PROJECT_NAME varchar(30)      not null comment '프로젝트 이름',
    PROJECT_DESC varchar(250)     not null comment '프로젝트 설명',
    constraint pf_land_user_project_list_UPL_NO_uplindex
        unique (UPL_NO)
);

create table pf_land_user_skills
(
    SKL_NO   int auto_increment comment '스킬 리스트 고유값'
        primary key,
    UPNO     int         not null comment '프로필 테이블 고유값',
    SKL_NAME varchar(30) not null comment '스킬 이름',
    constraint pf_land_user_skills_SKL_NO_sklindex
        unique (SKL_NO)
);

create table pf_land_user_task_list
(
    TKNO      int auto_increment comment '업무 테이블 고유값'
        primary key,
    UPNO      int          not null comment '프로필 테이블 고유값',
    TASK_DESC varchar(250) not null comment '업무 설명',
    constraint pf_land_user_task_list_TKNO_uindex
        unique (TKNO)
);

