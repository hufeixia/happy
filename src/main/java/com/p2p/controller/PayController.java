package com.p2p.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.p2p.dto.AccountMoneyDto;
import com.p2p.model.Account;
import com.p2p.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class PayController {
    private final String APP_ID = "2016102100731036";
    private final String APP_PRIVATE_KEY = "MIIEugIBADANBgkqhkiG9w0BAQEFAASCBKQwggSgAgEAAoIBAQCBcj107YhIOSlavIBwtLKsGVhQqTcOPHxGOp/pOl+ZzEeE79XDpWh2RlzfZRd7EPxfJkArXX/vOVbmtmq3pLWcs8EwCKLgZ4T3F0B1zeK11PM/cdsH7AQz0cz8vzYU1aqNokjMsF16XaFsBJ0ReOLXpHNE0uK1WCCqcUZFpJqqfKV5clzMOL3vLqZybnYHTjXztCVtXOuIp0R4BY8l2r34ilxMfPCxJp/uIYusau5vhhTXgJU4Annj+PFFW3KXodJVmWbVahwWtHKv5qn4trqIoe8Cq446hqY8427WHnviw/D3vdVrlxm5Ag81JTtz8F6TCDKKZ/HEDTLMKe1xzH5BAgMBAAECgf8XQm/IkuXqFFtZ8oUhu1Zfli5IUB+Ub0nlVKNnRRXojMxNFstSXGZo2jvV6FRPyL2QW08se6CBW8xBqIWEehQoFCSifOrHZ9J8k7EBef1CrwEGZW71/XLD3O74e2M8WyhKSt7J6ObjFe/reOjAOviHxwTvWPVjoHI+LhxyZyFjgL6D0yKGblmuU65i5aPVASJxlbud7Ebyw+PSOotwRzP8XvgZxAvRFsLlGFGSzrE1NrQiLZ1dd8wEb29jFFA+z7ZZR+m1xW+TfddTyz3IcNGbEwJL4jcL6Jmgkh7yN/foisyh62Z6DeJuKAVnA0TWpHXHeHz4UmJgneaos3TnJRkCgYEA7RJvWWcj/42GJgJVHr8VhCmSmdBFAfuJSUoQNUTVM/saW40JmUfZB0MTIvt9p40sk5FgxjXkcf516npR9cyOMNnJ8zNXF6Aq774wdbrqm/c1HT2fh2VNvb783u0Tv9h0n7iuE1iokw/eV0/FwwxIE/9Jqatdl8I1ZdCIxqQjuRsCgYEAi8gE9lE8ZLbu1YMkUzmBOm0Vbqojoet9fXs2GPK0DhYRpRRnZN1rxUeunJ+Hn9e+K90K8vD2LCcAgjd6dWvF9BIb6I2SNJ3lzEzJTNtkmL6KyiRA1SJyhuawT9DkQOYTugNonnokKuux5t+ehF0FPRmx6pfACDPsgxmro3FEl9MCgYA00TuflnwNrnEpvLFMJVRc2oo/3IfTVkAS5P5Rb+F0MEiCBx0RWlF+7bGwxIkNMEWzJtuBrXYU85U/xTrHYWh4d70ngtOvfs6yFRRk1lz4nI3n0tfc6XP1hzx9SiJxRn9NKm8V/lWoVgu6NhqgRvc0BVdbBsPWUL1mzpv6bY1L6wKBgBneCg0LO4Hn2Irqme5M1f1Z8n1oPu/YBIEULA6x22A/9UP3YqrnzunTOh0B6LdL1YWIgl4y+VtyXEW8voy8RQXF1CRVDpluHviPvTDb6OHbYRPHYbgPh+IvDrG2lobsDPp/Zvzs3YST2XhAKbWVAUMtXh9rtb3O3hXkyj6U13zBAoGAXmMKE4lzGNRsGveK4cw+zR4uznTA2352chyyveUd+ftVI4yht80Uj/CRb1vu93eiWS8ruEEZ0bUBpr+H+ftG76jO0tZ9u12V1pC3gz3BK368/hZfK7Yy0GzWQqFeo5KiHmhgh4KUIz/nUPHrcXoA0e4JUXGiaNDWjf2dt2O5P7o=";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://localhost:8088/#/Accounts";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8088/#/Accounts";

    @Autowired
    private IAccountService accountService;


    @RequestMapping("alipay")
    public void alipay(HttpServletResponse httpResponse,HttpServletRequest req) throws IOException {

        Random r=new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String moeny = req.getParameter("alipayMoney");
        Integer alipayMoney = 0;
        if(null!=moeny){
            alipayMoney = Integer.parseInt(moeny);
        }
        String total_amount =Integer.toString(alipayMoney);
        //订单名称，必填
        String subject ="奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        //商品描述，可空
        String body = "尊敬的会员欢迎购买奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
            Account account = new Account();
            if(null!=req.getParameter("uname")){
                account.setUname(req.getParameter("uname"));
                Account acc = accountService.QueryAccount(account);
                account.setMoney(alipayMoney);
                account.setAmount(acc.getAmount()+account.getMoney());
                account.setAvail(acc.getAvail()+account.getMoney());
                int i = accountService.UpdateAccountAlipayMoney(account);
                if(0!=i){
                    System.out.println("用户金额充值成功");
                }
            }

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


//    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
//    public void returnUrl(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, AlipayApiException {
//        System.out.println("=================================同步回调=====================================");
//
//        // 获取支付宝GET过来反馈信息
//        Map<String, String> params = new HashMap<String, String>();
//        Map<String, String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
//            }
//            // 乱码解决，这段代码在出现乱码时使用
//            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
//            params.put(name, valueStr);
//        }
//
//        System.out.println(params);//查看参数都有哪些
//        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
//        //验证签名通过
//        if(signVerified){
//            // 商户订单号
//            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
//
//            // 支付宝交易号
//            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
//
//            // 付款金额
//            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
//
//            System.out.println("商户订单号="+out_trade_no);
//            System.out.println("支付宝交易号="+trade_no);
//            System.out.println("付款金额="+total_amount);
//
//            //支付成功，修复支付状态
//            System.out.println("支付成功");
////            payService.updateById(Integer.valueOf(out_trade_no));
////            return "ok";//跳转付款成功页面
////        }else{
////            return "no";//跳转付款失败页面
//        }
//
//    }
}
