package com.nchu.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by user12 on 2018/2/17.
 */
public class Interceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");

        if (request.getSession().getAttribute("User")!=null){
            //session存在
            System.out.println("session存在 ");
            return true;
        }else {
            System.out.println("session不存在 ，请登陆");
            response.sendRedirect("/login");
            return false;
        }

    }
}
