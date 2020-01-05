package com.p2p.service;

import com.p2p.model.Images;
import com.p2p.util.PageBean;

import java.util.List;

public interface ImagesService {
    int deleteByPrimaryKey(Integer iid);

    int insert(Images record);

    int insertSelective(Images record);

    Images selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Images record);

    int ImagesByPrimaryImgType(Images record);

    List<Images> listImagesPage(Images images, PageBean pageBean);

    Images QueryImgPath(Images images);

    Images ImagesPath(Images images);

    int UpdateImages(Images images);

    int NoImg(Images images);

    int SumScope(String uname);

}