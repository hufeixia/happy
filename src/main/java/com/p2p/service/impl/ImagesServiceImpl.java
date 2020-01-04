package com.p2p.service.impl;

import com.p2p.mapper.ImagesMapper;
import com.p2p.model.Images;
import com.p2p.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImagesMapper imagesMapper;

    @Override
    public int deleteByPrimaryKey(Integer iid) {
        return 0;
    }

    @Override
    public int insert(Images record) {
        return imagesMapper.insert(record);
    }

    @Override
    public int insertSelective(Images record) {
        return 0;
    }

    @Override
    public Images selectByPrimaryKey(Integer iid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Images record) {
        return 0;
    }

    @Override
    public int ImagesByPrimaryImgType(Images record) {
        return imagesMapper.ImagesByPrimaryImgType(record);
    }
}
