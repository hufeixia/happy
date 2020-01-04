package com.p2p.mapper;

import com.p2p.model.SysUserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}