package com.p2p.controller;

import com.p2p.model.Images;
import com.p2p.service.ImagesService;
import com.p2p.util.BaseUtil;
import com.p2p.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ImagesController {

    @Autowired
    private ImagesService imagesService;

    @RequestMapping(value = "/ImgUpload",produces="text/json;charset=utf-8")
    @ResponseBody
    @CrossOrigin
    public String upload(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request) throws IOException {
        for (MultipartFile multipartFile : file) {
            Images img = new Images();
            String targetPath = "/upload/"+multipartFile.getOriginalFilename();
            String realPath = request.getServletContext().getRealPath(targetPath);
            multipartFile.transferTo(new File(realPath));
            img.setUname(request.getServletContext().getAttribute("username").toString());
            img.setItype(multipartFile.getOriginalFilename().substring(0,multipartFile.getOriginalFilename().indexOf(".")));
            img.setImgPath(targetPath);
            imagesService.insert(img);
            return realPath;
        }
        return null;
    }

    @RequestMapping(value = "/listImagesPage")//查询
    @CrossOrigin
    @ResponseBody
    public Map listImagesPage(Images images, HttpServletRequest req) {
        PageBean pageBean = new PageBean();
        pageBean.initPageBean(req, pageBean);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Images> images1 = imagesService.listImagesPage(images, pageBean);
        map.put("images1", images1);
        map.put("page", pageBean.getPage());
        map.put("total", pageBean.getTotal());
        map.put("rows", pageBean.getRows());
        return map;
    }


    @RequestMapping(value = "/QueryImage",produces="text/html;charset=UTF-8")//
    @CrossOrigin
    @ResponseBody
    public String QueryImage(Images images,HttpServletRequest request) throws  Exception {
        String realPath = request.getServletContext().getRealPath(images.getImgPath());
        String imageStr = BaseUtil.GetImageStr(realPath);
        BaseUtil.GenerateImage(imageStr, realPath);
        return imageStr;
    }

    @RequestMapping(value = "/updateImage")
    @ResponseBody
    @CrossOrigin
    public Map updateImage(Images images) {
        System.out.println(images);
        Map<String,Object> messgae = new HashMap<String,Object>();
        int i = imagesService.UpdateImages(images);
        if(0!=i){
            messgae.put("code",1);
            messgae.put("updateInfo","审核通过");
        }else{
            messgae.put("updateInfo","审核未通过");
        }
        return messgae;
    }

    @RequestMapping(value = "/NoImg")
    @ResponseBody
    @CrossOrigin
    public Map NoImg(Images images) {
        Map<String,Object> messgae = new HashMap<String,Object>();
        int i = imagesService.NoImg(images);
        if(0!=i){
            messgae.put("code",1);
            messgae.put("updateInfo","已拒绝审核");
        }
        return messgae;
    }

    @RequestMapping(value = "/sumScope")
    @ResponseBody
    @CrossOrigin
    public String sumScope(String uname) {
        return imagesService.SumScope(uname)+"";
    }


}
