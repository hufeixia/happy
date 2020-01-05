package com.p2p.service;

import com.p2p.dto.UserDto;
import com.p2p.model.Users;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUsersService {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users UsersByPrimaryName(String  userName);

    //连表查询
    List<UserDto> seleDtoPage(String username,String startDate,String endDate, PageBean pageBean);

}