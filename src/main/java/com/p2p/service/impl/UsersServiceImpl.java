package com.p2p.service.impl;

import com.p2p.dto.UserDto;
import com.p2p.mapper.UsersMapper;
import com.p2p.model.Users;
import com.p2p.service.IUsersService;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return 0;
    }

    @Override
    public int insert(Users record) {

        return usersMapper.insert(record);
    }

    @Override
    public int insertSelective(Users record) {
        return 0;
    }

    @Override
    public Users selectByPrimaryKey(Integer userid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return 0;
    }

    @Override
    public Users UsersByPrimaryName(String userName) {
        return usersMapper.UsersByPrimaryName(userName);
    }

    @Override
    public List<UserDto> seleDtoPage(String username, String startDate, String endDate, PageBean pageBean) {
        return usersMapper.seleDtoPage(username, startDate, endDate, pageBean);
    }


}
