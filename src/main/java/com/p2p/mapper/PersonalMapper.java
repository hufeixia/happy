package com.p2p.mapper;

import com.p2p.model.Personal;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Personal record);

    int insertSelective(Personal record);

    Personal selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Personal record);

    int updateByPrimaryKey(Personal record);

    Personal PersonalByPrimaryName(String uname);
}