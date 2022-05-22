package com.tia.portfolio.api.profile.service;

import com.github.pagehelper.Page;
import com.tia.portfolio.api.common.util.TiMap;
import com.tia.portfolio.api.profile.model.Profile;
import com.tia.portfolio.api.profile.model.ProfileReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    SkillServiceImpl nm;

    public Page<TiMap> listBy(TiMap nr){
        return nm.listBy(nr);
    }

    public TiMap itemBy(TiMap nr) { return nm.itemBy(nr); }

    public void insert(TiMap n){
        nm.insert(n);
    }

    public void update(TiMap n){
        nm.update(n);
    }


}
