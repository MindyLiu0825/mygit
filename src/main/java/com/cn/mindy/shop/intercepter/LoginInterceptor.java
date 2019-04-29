package com.cn.mindy.shop.intercepter;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证拦截器
 * 用户身份认证拦截
 * 访问其他页面要先判断是否登录
 */
public class LoginInterceptor implements HandlerInterceptor{


    /**
     * 在执行handler之前执行
     * 用于用户认证校验、用户权限校验
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//            System.out.println("LoginInterceptor...........用户认证校验,用户权限校验........");
//             //得到请求的url  /ShopManager_Mindy/user/login.action
//             String  url = request.getRequestURI();
//
//             //login.action
//             url = url.substring(url.lastIndexOf("/")+1);
//             System.out.println("url = " + url);
//
//             //判断是否是公开地址
//            List<String> open_urls = ResourcesUtil.gekeyList("anonymousURL");
//
//            //遍历公开 地址，如果是公开 地址则放行
//            for(String open_url:open_urls){
//
//                if(url.indexOf(open_url) >= 0){
//
//                    //如果是公开 地址则放行
//                    return true;
//                }
//            }
//
//            //判断用户身份在session中是否存在
//            HttpSession session = request.getSession();
//            ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
//
//            //如果用户身份在session中存在放行
//            if(activeUser != null){
//
//                return true;
//            }
//
//
//
//            //执行到这里拦截，跳转到登陆页面，用户进行身份认证
//            request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
//
//
//
//            //如果返回false表示拦截不继续执行handler，如果返回true表示放行
//            return false;
             return true;

    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {



    }



}
