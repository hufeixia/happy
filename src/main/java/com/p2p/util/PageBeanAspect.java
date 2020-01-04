package com.p2p.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect  //启用aop功能
public class PageBeanAspect {
    @Around(value = "execution(* *..*Service.*Page(..))")
    public  Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        PageBean pageBean = null;
        //得到所有的参数
        Object[] args = proceedingJoinPoint.getArgs();
        //遍历参数
        for (Object arg : args) {
            //只拿pagebean相关信息
            if(arg instanceof  PageBean){
                pageBean = (PageBean)arg;
                 break;
            }
        }
        if(pageBean!=null && pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }
        Object result = proceedingJoinPoint.proceed(args);
        if(pageBean!=null && pageBean.isPagination() && result !=null && result instanceof List){
            List alists = (List)result;
            PageInfo pageInfo = new PageInfo(alists);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }

        return result;
    }
}
