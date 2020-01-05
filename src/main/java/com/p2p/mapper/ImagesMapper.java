package com.p2p.mapper;

import com.p2p.model.Images;
import com.p2p.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Images record);

    int insertSelective(Images record);

    Images selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Images record);

    int ImagesByPrimaryImgType(Images record);

    List<Images> listImagesPage(Images images);

    Images QueryImgPath(Images images);

    Images ImagesPath(Images images);

    int UpdateImages(Images images);

    int NoImg(Images images);

    int SumScope(String uname);

}