package xyz.yylzsl.web.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Product;
import xyz.yylzsl.service.IProductService;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("findById/{pid}")
    public ModelAndView findById(@PathVariable("pid") String pid){

        ModelAndView mv = new ModelAndView();
        Product product = productService.findByPid(pid);
        mv.addObject("product",product);
        mv.setViewName("product_info");

        return mv;
    }

    @RequestMapping("/findByCid/{cid}")
    public ModelAndView findByCid(@PathVariable("cid")String cid, @RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "pageSize",required = true,defaultValue = "12")Integer pageSize){
        ModelAndView mv = new ModelAndView();

        List<Product> productList = productService.findByPageCid(cid,page,pageSize);
        PageInfo pageInfo = new PageInfo(productList);

        mv.addObject("pageInfo",pageInfo);
        mv.addObject("cid",cid);
        mv.setViewName("product_list");
        return mv;
    }

}
