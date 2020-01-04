package com.p2p.service;

import com.p2p.model.Identity;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityService {
    int deleteByPrimaryKey(Integer iid);

    int insert(Identity record);

    int insertSelective(Identity record);

    Identity IdentityByPrimaryRealName(String realName);

    int updateByPrimaryKeySelective(Identity record);

    int updateByPrimaryKey(Identity record);
}