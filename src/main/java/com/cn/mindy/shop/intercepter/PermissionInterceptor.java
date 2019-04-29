package com.cn.mindy.shop.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 授权拦截器
 */
public class PermissionInterceptor implements HandlerInterceptor {

    /**
     * 在执行handler之前来执行的
     * 用于用户认证校验、用户权限校验
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        System.out.println("LoginInterceptor.....用户认证校验、用户权限校验......");
//
//        //得到请求的url
//        String url = request.getRequestURI();
//        url = url.substring(url.lastIndexOf("/")+1);
//        System.out.println("url = " + url);
//
//        /**
//         * 认证拦截操作
//         * 判断是否是公开 地址
//         * 实际开发中需要公开 地址配置在配置文件中
//         * 从配置中取逆名访问url
//         */
//        List<String> open_urls = ResourcesUtil.gekeyList("anonymousURL");
//
//        //遍历公开 地址，如果是公开 地址则放行
//        for(String open_url:open_urls){
//
//            if(url.indexOf(open_url)>=0){
//                //如果是公开 地址则放行
//                return true;
//            }
//        }
//
//        /**
//         * 授权拦截操作
//         * 从配置文件中获取公共访问地址
//         */
//        List<String> common_urls = ResourcesUtil.gekeyList("cmmonURL");
//
//        //遍历公开 地址，如果是公开 地址则放行
//        for(String common_url:common_urls){
//
//            if(url.indexOf(common_url)>=0){
//
//                //如果是公开 地址则放行
//                return true;
//            }
//        }
//
//        /**
//         * 从session中获取请求的url
//         */
//        HttpSession session = request.getSession();
//
//        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
//
//        /**
//         * 判断用户身份在session中是否存在
//         * 如果用户身份在session中存在放行
//         */
//        if(activeUser==null){
//
//            //未登录
//            request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
//
//
//        }
//
//        /**
//         * 判断是否有menu权限
//         */
//        List<SysPermission> menus = activeUser.getMenus();
//
//        for (SysPermission sysPermission : menus) {
//
//            String permission_url = sysPermission.getUrl();
//
//            if(permission_url.indexOf(url) > 0){
//
//                //如果是权限的url 地址则放行
//                return true;
//            }
//        }
//
//
//        /**
//         * 判断是否有permission权限
//         */
//        List<SysPermission> permissions = activeUser.getPermissions();
//
//        for (SysPermission sysPermission : permissions) {
//
//            String permission_url = sysPermission.getUrl();
//
//            if(permission_url.indexOf(url) > 0){
//
//                //如果是权限的url 地址则放行
//                return true;
//            }
//        }
//
//        /**
//         * 执行到这里拦截，跳转到无权访问页面
//         */
//        request.getRequestDispatcher("/WEB-INF/jsp/refuse.jsp").forward(request, response);
//
//
//        //如果返回false表示拦截不继续执行handler，如果返回true表示放行
//        return false;
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
