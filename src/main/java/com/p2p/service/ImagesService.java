package com.p2p.service;

import com.p2p.model.Images;

public interface ImagesService {
    int deleteByPrimaryKey(Integer iid);

    int insert(Images record);

    int insertSelective(Images record);

    Images selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Images record);

    int ImagesByPrimaryImgType(Images record);
}