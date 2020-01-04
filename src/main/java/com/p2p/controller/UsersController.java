package com.p2p.controller;

import com.p2p.model.Users;
import com.p2p.service.IUsersService;
import com.p2p.shiro.PasswordHelper;
import com.p2p.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/Users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @RequestMapping(value = "/Login")
    @ResponseBody
    @CrossOrigin
    public Map Login(Users users,HttpServletRequest request) {
        String username = users.getUsername();
        String password = users.getPassword();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Map<String, Object> message = new HashMap();
        try {
            subject.login(token);
            message.put("code", 0);
            message.put("loginfo", "登录成功");
            request.getServletContext().setAttribute("username",token.getUsername());
            message.put("users", token);
        } catch (Exception e) {
            message.put("code", 1);
            message.put("loginfo", "抱歉账号或密码错误,请检查后重新登录");
        }
        return message;
    }

    @RequestMapping(value = "/Register")
    @ResponseBody
    @CrossOrigin
    public Map Register(Users users) {
        Map<String, Object> message = new HashMap();
        //盐
        String salt = PasswordHelper.createSalt();
        //凭证+盐加密后得到的密码
        String credentials = PasswordHelper.createCredentials(users.getPassword(), salt);
        users.setPassword(credentials);
        users.setSalt(salt);
        System.out.println("users"+users);
        try {
           int insert = usersService.insert(users);
            if(insert!=0){
                message.put("code", insert);
                message.put("RegisterInfo", "注册成功");
            }else{
                message.put("RegisterInfo", "注册失败,输入的验证码有误");
            }
        } catch (Exception e) {
            message.put("RegisterInfo", "注册失败,该用户已被注册");
        }
        return message;
    }


    @RequestMapping(value = "/AuthRegister")
    @ResponseBody
    @CrossOrigin
    public int AuthRegister(@RequestParam String tel) {
        String host = "https://khymsg.market.alicloudapi.com";
        String path = "/khymsg";
        String method = "POST";
        String appcode = "e5d5c823b31945109cadeefd76c4b8b3";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        int rd = (int) ((Math.random() * 9 + 1) * 100000);
        querys.put("content", "【卡池】尊敬的用户，您本次验证码是" + rd);
        querys.put("mobile", tel);
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rd;
    }

    @RequestMapping(value = "/queryTel")
    @ResponseBody
    @CrossOrigin
    public Users queryTel(Users users) {
        Users u = usersService.UsersByPrimaryName(users.getUsername());
        if(null!=u){
            String s = u.getTel().replaceAll("(?<=[\\d]{3})\\d(?=[\\d]{4})", "*");
            u.setTel(s);
        }

        return u;
    }

}
