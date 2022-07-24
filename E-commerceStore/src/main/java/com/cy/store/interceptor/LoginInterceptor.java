package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        Object uid = request.getSession().getAttribute("uid");

        //说明用户没有登录，判断是否获取到uid，如果没有，重定向到登录页面
        if (uid == null){
            response.sendRedirect("/web/login.html");
            return false;
        }
        //如果获取到uid，直接放行
        return true;
    }
}
