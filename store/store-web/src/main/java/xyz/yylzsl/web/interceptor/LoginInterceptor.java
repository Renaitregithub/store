package xyz.yylzsl.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.User;
import xyz.yylzsl.service.IUserService;
import xyz.yylzsl.utils.CookUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 登录页面
        // 用户session
        // 用户cookie
        if(request.getRequestURI().indexOf("loginUI")>=0){
            return true;
        }

        User loginUserSession = (User) request.getSession().getAttribute("loginUserSession");
        if(loginUserSession!=null){
            return true;
        }

        Cookie autoLoginCookie = CookUtils.getCookieByName("autoLoginCookie", request.getCookies());
        if(autoLoginCookie==null){
            return true;
        }else{
            String[] split = autoLoginCookie.getValue().split("@");
            String username = split[0];
            String password = split[1];
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user = userService.findByUserAndPassword(user);
            // 自动登录
            if(user!=null){
                request.getSession().setAttribute("loginUserSession",user);
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
