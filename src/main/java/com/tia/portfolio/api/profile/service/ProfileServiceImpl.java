package com.tia.portfolio.api.profile.service;

import com.github.pagehelper.Page;
import com.tia.portfolio.api.common.util.TiMap;
import com.tia.portfolio.api.profile.model.Profile;
import com.tia.portfolio.api.profile.model.ProfileReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileServiceImpl {

    public Page<TiMap> listBy(ProfileReq nr);

    public Page<TiMap> listChapterBy(ProfileReq nr);

    public TiMap itemBy(TiMap nr);

    public void insertNovel(Profile n);

    public void updateNovel(Profile n);
}