package xyz.yylzsl.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminPageController {

    @RequestMapping(value = {"/",""})
    public ModelAndView showIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/login");
        return mv;
    }
}
