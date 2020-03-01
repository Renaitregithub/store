package xyz.yylzsl.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Admin;
import xyz.yylzsl.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPrivilegeInterfaceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin adminSession = (Admin) request.getSession().getAttribute("adminSession");

        if(adminSession==null){
            request.setAttribute("msg","您还没有登录！,没有权限访问");
            request.getRequestDispatcher("/WEB-INF/pages/jsp/admin/login.jsp").forward(request,response);
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
