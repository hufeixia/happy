package com.p2p.service;

import com.p2p.model.Personal;

public interface IPersonalService {
    int deleteByPrimaryKey(Integer pid);

    int insert(Personal record);

    int insertSelective(Personal record);

    Personal selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Personal record);

    int updateByPrimaryKey(Personal record);

    Personal PersonalByPrimaryName(String uname);
}