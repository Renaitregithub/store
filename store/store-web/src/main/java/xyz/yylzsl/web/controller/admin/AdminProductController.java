package xyz.yylzsl.web.controller.admin;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Category;
import xyz.yylzsl.pojo.Product;
import xyz.yylzsl.service.ICategoryService;
import xyz.yylzsl.service.IProductService;
import xyz.yylzsl.utils.UUIDUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/adminProduct")
public class AdminProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/findAll")
    public ModelAndView findByPage(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name="pageSize",required = true,defaultValue = "10") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findByPage(page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("/admin/product/list");
        return mv;
    }

    @RequestMapping("/showAdd")
    public ModelAndView showAdd() throws Exception {
        List<Category> list = categoryService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("/admin/product/add");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView Add(Product product, MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        String fileName = "";
        String uploadFileName = uploadFile.getOriginalFilename();
        String extendName = uploadFileName.substring(uploadFileName.lastIndexOf("."))+1;

        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        if(!StringUtils.isEmpty(product.getPimage())){
            fileName = uuid+"_"+product.getPimage()+"."+extendName;
        }else{
            fileName = uuid+"_"+uploadFileName;
        }

        ServletContext servletContext = request.getServletContext();
        String basePath = servletContext.getRealPath("/WEB-INF/products/3");
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File file = new File(basePath + "/" + datePath);
        if(!file.exists()){
            file.mkdirs();
        }
        uploadFile.transferTo(new File(file,fileName));
        product.setPid(UUIDUtils.getId());
        product.setPdate(new Date());
        product.setPflag(0);

        System.out.println(product);

        productService.save(product);
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findByPage(0,10);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("/admin/product/list");
        return mv;
    }

    @RequestMapping("/showEdit")
    public ModelAndView showEdit(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/admin/category/edit");
        return mv;
    }

    @RequestMapping("/isFlag")
    public ModelAndView isFlag(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/admin/category/");
        return mv;
    }

}
