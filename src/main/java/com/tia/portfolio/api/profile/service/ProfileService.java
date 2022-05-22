package com.tia.portfolio.api.profile.service;

import com.github.pagehelper.Page;
import com.tia.portfolio.api.common.util.TiMap;
import com.tia.portfolio.api.profile.model.Profile;
import com.tia.portfolio.api.profile.model.ProfileReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileServiceImpl nm;

    public Page<TiMap> listBy(ProfileReq nr){
        return nm.listBy(nr);
    }

    public TiMap itemBy(TiMap nr) { return nm.itemBy(nr); }

    public void insert(Profile n){
        nm.insert(n);
    }

    public void update(Profile n){
        nm.update(n);
    }

}
