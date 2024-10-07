package com.tbl.studentmanager.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tbl.studentmanager.utils.SysUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求头中的Authorization
//        String authorization = request.getHeader("Authorization");
//
//        // 检查Authorization是否为期望的值，这里假设我们期望的值是"Bearer your-token"
//        if ("Bearer your-token".equals(authorization)) {
//            // 如果匹配，则继续处理请求
//            return true;
//        } else {
//            // 如果不匹配，设置401状态码，表示未授权
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            // 可以选择返回错误信息
//            response.getWriter().write("Unauthorized");
//            // 返回false，表示拦截请求，不再继续处理
//            return false;
//        }
        SysUtils.checkOnline();
        return true;
    }
}
