package xyz.yylzsl.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Admin;
import xyz.yylzsl.service.IAdminService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService service;

    @RequestMapping("/login")
    public ModelAndView login(Admin admin, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        admin = service.login(admin);
        if(admin!=null){
            mv.setViewName("/admin/home");
            request.getSession().setAttribute("admin",admin);
//            mv.addObject("admin",admin);
            return mv;
        }else{
            mv.addObject("msg","登录失败");
            mv.setViewName("/admin/index");
            return mv;
        }


    }
}
