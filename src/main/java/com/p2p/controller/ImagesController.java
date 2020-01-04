package com.p2p.controller;

import com.p2p.model.Images;
import com.p2p.service.ImagesService;
import com.p2p.util.Base64Util;
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
import java.util.Map;

@Controller
@CrossOrigin
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

}
