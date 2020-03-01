package xyz.yylzsl.web.controller.admin;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Category;
import xyz.yylzsl.service.ICategoryService;
import xyz.yylzsl.utils.UUIDUtils;

import java.util.List;

@Controller
@RequestMapping("/adminCategory")
public class AdminCategoryController {

    @Autowired
    private ICategoryService service;

    @ModelAttribute
    public ModelAndView before(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name="pageSize",required = true,defaultValue = "8") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Category> list = service.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    /**
     * 分页查询
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView mv) throws Exception {
        mv.setViewName("admin/category/category-list");
        return mv;
    }

    /**
     * 显示添加页面
     * @return
     */
    @RequestMapping("/showAdd")
    public ModelAndView showAdd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/category/category-add");
        return mv;
    }

    /**
     * 添加分类
     * @param category
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    public ModelAndView Add(Category category,ModelAndView mv) throws Exception {
        category.setCid(UUIDUtils.getId());
        service.save(category);
        mv.setViewName("/admin/category/category-list");
        return mv;
    }

    @RequestMapping("/showEdit/{cid}")
    public ModelAndView showEdit(@PathVariable("cid")String cid){
        ModelAndView mv = new ModelAndView();
        Category category = service.findByCid(cid);
        mv.addObject("category",category);
        mv.setViewName("/admin/category/category-edit");
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(Category category,ModelAndView mv) throws Exception {
        service.update(category);
        List<Category> list = service.findAll(1,8);
        mv.addObject("list",list);
        mv.setViewName("/admin/category/category-list");
        return mv;
    }

    /**
     * 删除分类
     * @param cid
     * @return
     * @throws Exception
     */
    @RequestMapping("/showDel/{cid}")
    public ModelAndView delete(@PathVariable("cid") String cid,ModelAndView mv) throws Exception {
        service.delete(cid);
        mv.setViewName("/admin/category/category-list");
        return mv;
    }

}
