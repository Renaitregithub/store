package xyz.yylzsl.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Admin;
import xyz.yylzsl.pojo.User;
import xyz.yylzsl.service.IAdminService;
import xyz.yylzsl.service.IUserService;
import xyz.yylzsl.utils.CookUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private IAdminService adminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 登录页面
        // 用户session
        // 用户cookie
        if(request.getRequestURI().indexOf("admin")>=0){
            return true;
        }

        Admin adminSession = (Admin) request.getSession().getAttribute("adminSession");
        if(adminSession!=null){
            return true;
        }

        Cookie adminSessionCookie = CookUtils.getCookieByName("adminSession", request.getCookies());
        if(adminSessionCookie==null){
            return true;
        }else{
            String[] split = adminSessionCookie.getValue().split("@");
            String username = split[0];
            String password = split[1];
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            admin = adminService.login(admin);
            // 自动登录
            if(admin!=null){
                request.getSession().setAttribute("adminSession",admin);
                return true;
            }
        }


        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
