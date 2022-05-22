package com.tia.portfolio.api.profile.service;

import com.github.pagehelper.Page;
import com.tia.portfolio.api.common.util.TiMap;
import com.tia.portfolio.api.profile.model.Profile;
import com.tia.portfolio.api.profile.model.ProfileReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkillServiceImpl {

    public Page<TiMap> listBy(TiMap nr);

    public TiMap itemBy(TiMap nr);

    public void insert(TiMap n);

    public void update(TiMap n);


}
