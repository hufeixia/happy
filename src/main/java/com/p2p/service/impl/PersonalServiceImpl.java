package com.p2p.service.impl;

import com.p2p.mapper.PersonalMapper;
import com.p2p.model.Personal;
import com.p2p.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServiceImpl implements IPersonalService {

    @Autowired
    private PersonalMapper personalMapper;

    @Override
    public int deleteByPrimaryKey(Integer pid) {
        return 0;
    }

    @Override
    public int insert(Personal record) {
        return personalMapper.insert(record);
    }

    @Override
    public int insertSelective(Personal record) {
        return 0;
    }

    @Override
    public Personal selectByPrimaryKey(Integer pid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Personal record) {
        return 0;
    }

    @Override
    public Personal PersonalByPrimaryName(String uname) {

        return personalMapper.PersonalByPrimaryName(uname);
    }

    @Override
    public int updateByPrimaryKey(Personal record) {
        return 0;
    }
}
