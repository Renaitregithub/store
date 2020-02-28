package xyz.yylzsl.web.controller;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.yylzsl.pojo.Category;
import xyz.yylzsl.service.ICategoryService;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/findAll")
    public @ResponseBody List findAll() throws Exception {
        List<Category> list = categoryService.findAll();
        return list;
    }

}
