package xyz.yylzsl.web.controller.admin;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.User;
import xyz.yylzsl.service.IUserService;
import xyz.yylzsl.utils.UUIDUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("adminUser")
public class AdminUserController {

    @Autowired
    private IUserService userService;

    @ModelAttribute
    public ModelAndView before(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name="pageSize",required = true,defaultValue = "6")Integer pageSize){

        ModelAndView mv = new ModelAndView();
        List<User> list = userService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        return mv;

    }

    @RequestMapping("/findAll")
    public ModelAndView findByPage(ModelAndView mv){
        mv.setViewName("admin/user/user-list");
        return mv;
    }

    @RequestMapping("/showAdd")
    public ModelAndView showAdd(ModelAndView mv) throws Exception {
        mv.setViewName("/admin/user/user-add");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(User user,ModelAndView mv) throws Exception {
        user.setUid(UUIDUtils.getCode());
        user.setState(1);
        user.setCode(null);
        user.setBirthday(new Date());
        user.setSex("1");
        userService.regist(user);
        mv.setViewName("/admin/user/user-list");
        return mv;
    }

    @RequestMapping("/showEdit/{uid}")
    public ModelAndView showEdit(@PathVariable("uid")String uid){
        ModelAndView mv = new ModelAndView();
        User user = userService.findbyUid(uid);
        mv.addObject("user",user);
        mv.setViewName("/admin/user/user-edit");
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(User user,ModelAndView mv) throws Exception {
        User user1 = userService.findbyUid(user.getUid());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setTelephone(user.getTelephone());
        userService.update(user);
        mv.setViewName("/admin/user/user-list");
        return mv;
    }

    @RequestMapping("/showDel/{uid}")
    public ModelAndView delete(@PathVariable("uid") String uid, ModelAndView mv) throws Exception {
        userService.delete(uid);
        mv.setViewName("/admin/user/user-list");
        return mv;
    }
}
