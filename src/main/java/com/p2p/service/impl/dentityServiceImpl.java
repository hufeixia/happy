package com.p2p.service.impl;

import com.p2p.mapper.IdentityMapper;
import com.p2p.model.Identity;
import com.p2p.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dentityServiceImpl implements IdentityService {

    @Autowired
    private IdentityMapper identityMapper;

    @Override
    public int deleteByPrimaryKey(Integer iid) {
        return 0;
    }

    @Override
    public int insert(Identity record) {

        return identityMapper.insert(record);
    }

    @Override
    public int insertSelective(Identity record) {
        return 0;
    }

    @Override
    public Identity IdentityByPrimaryRealName(String realName) {
        return identityMapper.IdentityByPrimaryRealName(realName);
    }
    @Override
    public int updateByPrimaryKeySelective(Identity record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Identity record) {
        return 0;
    }
}
