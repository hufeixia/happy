package com.p2p.mapper;

import com.p2p.model.Images;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Images record);

    int insertSelective(Images record);

    Images selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Images record);

    int ImagesByPrimaryImgType(Images record);
}