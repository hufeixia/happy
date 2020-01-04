package com.p2p.mapper;

import com.p2p.model.SysPermission;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer perid);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer perid);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}