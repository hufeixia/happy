package com.p2p.service;

import com.p2p.model.SysPermission;

public interface ISysPermissionService {
    int deleteByPrimaryKey(Integer perid);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer perid);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}