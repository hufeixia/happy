package com.p2p.mapper;

import com.p2p.model.SysRolePermission;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRolePermissionMapper {
    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);
}