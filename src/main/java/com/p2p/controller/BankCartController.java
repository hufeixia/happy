package com.p2p.controller;

import com.p2p.model.BankCart;
import com.p2p.service.IBankCartService;
import com.p2p.util.Base64Util;
import com.p2p.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping(value = "/Bank")
public class BankCartController {

    @Autowired
    private IBankCartService bankCartService;

    @RequestMapping(value = "/addBank")
    @ResponseBody
    public Map addBank(BankCart bankCart) {
        Map<String, Object> message = new HashMap<String, Object>();
        int insert = bankCartService.insert(bankCart);
        if (0 != insert) {
            message.put("code", "0");
            message.put("addInfo", "银行卡绑定成功");
        } else {
            message.put("addInfo", "银行卡绑定失败");
        }
        return message;
    }

    //银行卡图片识别验证
    @RequestMapping(value = "/yhksb")
    @ResponseBody
    public String yhksb(@RequestParam(value = "file") MultipartFile[] file) throws IOException {
        if (file != null) {
            for (MultipartFile f : file) {
                String encode = Base64Util.encode(f.getBytes());//得到图片的base64格式
                String host = "https://bankocr.market.alicloudapi.com";
                String path = "/cardbank";
                String method = "POST";
                String appcode = "e5d5c823b31945109cadeefd76c4b8b3";
                Map<String, String> headers = new HashMap<String, String>();
                //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
                headers.put("Authorization", "APPCODE " + appcode);
                //根据API的要求，定义相对应的Content-Type
                headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                Map<String, String> querys = new HashMap<String, String>();
                Map<String, String> bodys = new HashMap<String, String>();
                //或者base64
                bodys.put("img", "data:image/jpeg;base64," + encode);
                try {
                    HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                    //获取response的body
                    return EntityUtils.toString(response.getEntity());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("啦啦啦");
        }
        return null;
    }


    //银行卡三要素验证
    @RequestMapping(value = "/yhksysyz", produces = "text/json;charset=utf-8")
    @ResponseBody
    public String yhksysyz(BankCart bankCart) throws IOException {
        String host = "https://tbank.market.alicloudapi.com";
        String path = "/bank3CheckNew";
        String method = "GET";
        String appcode = "e5d5c823b31945109cadeefd76c4b8b3";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("accountNo", bankCart.getBcartid());//银行卡号
        querys.put("idCard", bankCart.getBsfz());//身份证号
        querys.put("name", bankCart.getBealname());//姓名
        //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/Tools.zip

        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/QueryYhk")
    @ResponseBody
    public List<BankCart> QueryYhk(BankCart bankCart) {
        String bsfz = bankCart.getBsfz().replaceAll("(?<=[\\d]{10})\\d(?=[\\d]{4})", "*");
        bankCart.setBsfz(bsfz);
        System.out.println("-------------"+bankCart.getBsfz());
        List<BankCart> bankCarts = bankCartService.QueryBankCartBySfz(bankCart);
        return bankCarts;
    }
}
