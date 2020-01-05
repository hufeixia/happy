package com.p2p.service.impl;

import com.p2p.mapper.ImagesMapper;
import com.p2p.model.Images;
import com.p2p.service.ImagesService;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Images> listImagesPage(Images images, PageBean pageBean) {
        return imagesMapper.listImagesPage(images);
    }

    @Override
    public Images QueryImgPath(Images images) {
        return imagesMapper.QueryImgPath(images);
    }

    @Override
    public Images ImagesPath(Images images) {
        return imagesMapper.ImagesPath(images);
    }

    @Override
    public int UpdateImages(Images images) {

        return imagesMapper.UpdateImages(images);
    }

    @Override
    public int NoImg(Images images) {
        return imagesMapper.NoImg(images);
    }

    @Override
    public int SumScope(String uname) {
        return imagesMapper.SumScope(uname);
    }
}
