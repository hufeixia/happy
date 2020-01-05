package com.p2p.mapper;

import com.p2p.dto.UserDto;
import com.p2p.model.Users;
import com.p2p.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users UsersByPrimaryName(String userName);

    //连表查询
    List<UserDto> seleDtoPage(@Param("username")String username,@Param("startDate")String startDate,@Param("endDate")String endDate, PageBean pageBean);

}