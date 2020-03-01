package xyz.yylzsl.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Admin;
import xyz.yylzsl.service.IAdminService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService service;

    @RequestMapping("/login")
    public ModelAndView login(Admin admin, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        admin = service.login(admin);
        System.out.println(admin);
        if(admin!=null){
            admin.setLasttime(new Date());
            service.updateUser(admin);
            String autoAdminLogin = request.getParameter("autoAdminLogin");
            if("1".equals(autoAdminLogin)){
                Cookie autoAdminLoginCookie = new Cookie("autoAdminLoginCookie", admin.getUsername() + "@" + admin.getPassword());
                autoAdminLoginCookie.setPath("/");
                autoAdminLoginCookie.setMaxAge(60*60*24*7);
                response.addCookie(autoAdminLoginCookie);
            }else{
                Cookie autoAdminLoginCookie = new Cookie("autoAdminLoginCookie","");
                autoAdminLoginCookie.setPath("/");
                autoAdminLoginCookie.setMaxAge(0);
                response.addCookie(autoAdminLoginCookie);
            }

            mv.setViewName("admin/main");
            request.getSession().setAttribute("adminSession",admin);
            return mv;
        }else{
            mv.addObject("msg","登录失败");
            mv.setViewName("admin/login");
            return mv;
        }


    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session){
        ModelAndView mv = new ModelAndView();
        session.removeAttribute("admin");
        mv.setViewName("admin/login");
        return mv;
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updateUser(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView();
        Admin admin = service.findById(id);
        mv.setViewName("admin/admin-user");
        return mv;
    }

    @RequestMapping("/showIndex")
    public ModelAndView showIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/main");
        return mv;
    }
}
