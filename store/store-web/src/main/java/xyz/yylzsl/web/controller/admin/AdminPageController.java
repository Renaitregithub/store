package xyz.yylzsl.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminPageController {

    @RequestMapping("/")
    public ModelAndView showIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/index");
        return mv;
    }

    @RequestMapping("/home")
    public ModelAndView showHome(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/home");
        return mv;
    }

    @RequestMapping("/showTop")
    public ModelAndView showTop(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/top");
        return mv;
    }

    @RequestMapping("/showLeft")
    public ModelAndView showLeft(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/left");
        return mv;
    }

    @RequestMapping("/showButtom")
    public ModelAndView showButton(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/bottom");
        return mv;
    }

    @RequestMapping("/showWelcome")
    public ModelAndView showWelcome(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/welcome");
        return mv;
    }
}
