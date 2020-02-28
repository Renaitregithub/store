package xyz.yylzsl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.User;
import xyz.yylzsl.service.IUserService;
import xyz.yylzsl.utils.UUIDUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 注册页面
     * @return
     */
    @RequestMapping("/registUI")
    public String registUI(){
        return "register";
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("/regist")
    public ModelAndView regist(User user, String verifyCode, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();
        String verifyCodeSession = (String) session.getAttribute("verifyCodeSession");
        if(!verifyCodeSession.equalsIgnoreCase(verifyCode)){
            mv.addObject("msg","验证码输入有误");
            mv.setViewName("register");
        }
        user.setUid(UUIDUtils.getId());
        user.setCode(UUIDUtils.getUUID64());
        user.setState(0);
        userService.regist(user);

        mv.addObject("msg","注册成功，请邮箱激活后登录");
        mv.setViewName("login");
        return mv;

    }

    /**
     * active
     * @return
     */
    @RequestMapping("/active")
    public ModelAndView active(String code){
        ModelAndView mv = new ModelAndView();
        try {
            userService.activeUser(code);
            mv.addObject("msg","激活成功，请登录");
        }catch (Exception e){
            e.printStackTrace();
            mv.addObject("msg",e.getMessage());
        }
        return mv;
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/loginUI")
    public String loginUI(){
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(User user,String verifyCode,String autoLogin,String rememberme,HttpSession session,HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String verifyCodeSession = (String) session.getAttribute("verifyCodeSession");
        if(!verifyCodeSession.equalsIgnoreCase(verifyCode)){
            mv.addObject("msg","验证码输入有误，请重新输入");
            mv.setViewName("login");
            return mv;
        }
        user = userService.findByUserAndPassword(user);
        if(user==null){
            mv.addObject("msg","用户名或匹马不匹配，或账户未通过邮件激活");
            mv.setViewName("login");
            return mv;
        }

        // 自动登录
        if("1".equals(autoLogin)){
            Cookie autoLoginCookie = new Cookie("autoLoginCookie", user.getUsername()+"@"+user.getPassword());
            autoLoginCookie.setPath("/");
            autoLoginCookie.setMaxAge(60*60*24*7);
            response.addCookie(autoLoginCookie);
        }else{
            Cookie autoLoginCookie = new Cookie("autoLoginCookie", "");
            autoLoginCookie.setPath("/");
            autoLoginCookie.setMaxAge(0);
            response.addCookie(autoLoginCookie);
        }
        // 记住用户名
        if("1".equals(rememberme)){
            Cookie remembermeCookie = new Cookie("remembermeCookie", user.getUsername());
            remembermeCookie.setPath("/");
            remembermeCookie.setMaxAge(60*60*24*7);
            response.addCookie(remembermeCookie);
        }else{
            Cookie remembermeCookie = new Cookie("remembermeCookie", "");
            remembermeCookie.setPath("/");
            remembermeCookie.setMaxAge(0);
            response.addCookie(remembermeCookie);
        }
        session.setAttribute("loginUserSession",user);
        mv.setViewName("index");
        return mv;
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUserSession");
        return "index";
    }

    /**
     * 检查用户名
     * @param username
     */
    @RequestMapping("/checkUsername")
    public void checkUsername(String username,HttpServletResponse response) throws IOException {
        User user = userService.findByUsername(username);
        if(user==null){
            response.getWriter().println(2);
        }else{
            response.getWriter().println(1);
        }
    }
}
