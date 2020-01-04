package com.p2p.controller;

import com.p2p.util.HttpUtils;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping(value = "/Auth")
public class AuthController {

    @RequestMapping(value = "/AuthCartImage")
    @CrossOrigin
    @ResponseBody
    public String AuthCartImage(String baseimage)throws  Exception{
        String url = "https://idcardocrc.shumaidata.com/getidcardocrc";
        String appCode = "e5d5c823b31945109cadeefd76c4b8b3";

        Map<String, String> params = new HashMap<>();
        params.put("image",baseimage);
        String result = postForm(appCode, url, params);
        return result;
    }

    /**
     * 用到的HTTP工具包：okhttp 3.13.1
     * <dependency>
     * <groupId>com.squareup.okhttp3</groupId>
     * <artifactId>okhttp</artifactId>
     * <version>3.13.1</version>
     * </dependency>
     */
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
        System.out.println("返回状态码" + response.code() + ",message:" + response.message());
        String result = response.body().string();
        return result;
    }


}
