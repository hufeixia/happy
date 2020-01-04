package com.p2p.controller;

import com.p2p.model.Images;
import com.p2p.service.ImagesService;
import com.p2p.util.Base64Util;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    private ImagesService imagesService;

    @RequestMapping(value = "/Upload",produces="text/json;charset=utf-8")
    @ResponseBody
    @CrossOrigin
    public String upload(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request) throws IOException {
        System.out.println(request.getParameter("iid"));

        if (null!=file) {
            for (MultipartFile f : file) {
                String path = "/upload/" + f.getOriginalFilename();
                String realPath = request.getServletContext().getRealPath(path);
                String encode = Base64Util.encode(f.getBytes());//得到图片的base64格式
                String url = "https://idcardocrc.shumaidata.com/getidcardocrc";
                String appCode = "e5d5c823b31945109cadeefd76c4b8b3";
                Map<String, String> params = new HashMap<>();
                params.put("image", "data:image/jpg;base64," + encode);
                String result = postForm(appCode, url, params);
                System.out.println(result);
                f.transferTo(new File(realPath));
                Images images = new Images();
                images.setIdentityid(System.currentTimeMillis()+"");
                
                images.setImgPath(path);
                images.setItype("身份证信息");

                int insert = imagesService.insert(images);
                if(0!=insert){
                    request.getSession().getServletContext().setAttribute("iid",images.getIdentityid());
                }
                return result;
            }
        }
        return "ok";
    }

    @CrossOrigin
    @ResponseBody
    public static String postForm(String appCode, String url, Map<String, String> params) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();
        FormBody.Builder formbuilder = new FormBody.Builder();
        Iterator<String> it = params.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            formbuilder.add(key, params.get(key));
        }
        FormBody body = formbuilder.build();
        Request request = new Request.Builder().url(url).addHeader("Authorization", "APPCODE " + appCode).post(body).build();
        Response response = client.newCall(request).execute();
//        System.out.println("返回状态码" + response.code() + ",message:" + response.message());
        String result = response.body().string();
        return result;
    }

}
