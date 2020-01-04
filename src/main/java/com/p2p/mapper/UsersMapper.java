package com.p2p.mapper;

import com.p2p.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users UsersByPrimaryName(String userName);

}