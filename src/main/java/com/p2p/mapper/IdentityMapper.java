package com.p2p.mapper;

import com.p2p.model.Identity;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Identity record);

    int insertSelective(Identity record);

    Identity IdentityByPrimaryRealName(String realName);

    int updateByPrimaryKeySelective(Identity record);

    int updateByPrimaryKey(Identity record);
}