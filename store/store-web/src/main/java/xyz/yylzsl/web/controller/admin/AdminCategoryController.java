package xyz.yylzsl.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Category;
import xyz.yylzsl.service.ICategoryService;
import xyz.yylzsl.service.impl.CategoryServiceImpl;
import xyz.yylzsl.utils.UUIDUtils;

import java.util.List;

@Controller
@RequestMapping("/adminCategory")
public class AdminCategoryController {

    @Autowired
    private ICategoryService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Category> list = service.findAll();
        mv.addObject("list",list);
        mv.setViewName("/admin/category/list");
        return mv;
    }

    @RequestMapping("/showAdd")
    public ModelAndView showAdd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/admin/category/add");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView Add(Category category) throws Exception {
        ModelAndView mv = new ModelAndView();

        category.setCid(UUIDUtils.getId());
        service.save(category);
        List<Category> list = service.findAll();
        mv.addObject("list",list);
        mv.setViewName("/admin/category/list");
        return mv;
    }

    @RequestMapping("/showEdit/{cid}")
    public ModelAndView showEdit(@PathVariable("cid")String cid){
        ModelAndView mv = new ModelAndView();
        Category category = service.findByCid(cid);
        mv.addObject("category",category);
        mv.setViewName("/admin/category/edit");
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(Category category) throws Exception {
        ModelAndView mv = new ModelAndView();
        service.update(category);
        List<Category> list = service.findAll();
        mv.addObject("list",list);
        mv.setViewName("/admin/category/list");
        return mv;
    }

    @RequestMapping("/showDel/{cid}")
    public ModelAndView delete(@PathVariable("cid") String cid) throws Exception {
        ModelAndView mv = new ModelAndView();
        service.delete(cid);
        List<Category> list = service.findAll();
        mv.addObject("list",list);
        mv.setViewName("/admin/category/list");
        return mv;
    }

}
