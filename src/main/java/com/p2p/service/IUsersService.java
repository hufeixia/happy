package com.p2p.service;

import com.p2p.model.Users;
import org.springframework.stereotype.Service;

public interface IUsersService {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users UsersByPrimaryName(String  userName);

}