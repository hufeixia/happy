package com.p2p.service;

import com.p2p.model.SysRolePermission;

public interface ISysRolePermissionService {
    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);
}