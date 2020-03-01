package xyz.yylzsl.web.controller.admin;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import javax.servlet.http.HttpServletResponse;
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


    @ModelAttribute
    public ModelAndView before(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name="pageSize",required = true,defaultValue = "6")Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findByPage(page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        List<Category> category = categoryService.findAll(1, 20);
        mv.addObject("category",category);
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @RequestMapping("/findAll")
    public ModelAndView findByPage(ModelAndView mv){
        mv.setViewName("/admin/product/product-list");
        return mv;
    }

    @RequestMapping("/showAdd")
    public ModelAndView showAdd(ModelAndView mv) throws Exception {
        List<Category> list = categoryService.findAll(1, 8);
        mv.addObject("list",list);
        mv.setViewName("/admin/product/product-add");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView Add(Product product,String cid, MultipartFile upload, HttpServletRequest request,ModelAndView mv) throws IOException {

        String filename = "";
        String fileUploadName = upload.getOriginalFilename();
        String extendName = fileUploadName.substring(fileUploadName.lastIndexOf(".")+1);

        String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        filename = uuid+"."+extendName;

        String basePath = request.getServletContext().getRealPath("/WEB-INF/pages/products/3");
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File file = new File(basePath, datePath);
        if(!file.exists()){
            file.mkdirs();
        }
        upload.transferTo(new File(file,filename));

        product.setPimage("products/3/"+datePath+"/"+filename);
        product.setPid(UUIDUtils.getId());
        product.setPdate(new Date());
        Category category = new Category();
        category.setCid(cid);
        product.setCategory(category);
        product.setPflag(0);

        System.out.println(product);

        productService.save(product);
        mv.setViewName("/admin/product/product-list");
        return mv;
    }


    @RequestMapping("/showEdit/{pid}")
    public ModelAndView showEdit(@PathVariable("pid")String pid,ModelAndView mv) {
        Product product = productService.findByPid(pid);
        mv.addObject("product",product);
        mv.setViewName("/admin/product/product-edit");
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(Product product,MultipartFile upload,String cid,HttpServletRequest request) throws IOException {

        if(upload.getOriginalFilename()!=null&&upload.getOriginalFilename().length()>0) {
            String filename = "";
            String fileUploadName = upload.getOriginalFilename();
            String extendName = fileUploadName.substring(fileUploadName.lastIndexOf(".") + 1);

            String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            filename = uuid + "." + extendName;

            String basePath = request.getServletContext().getRealPath("/WEB-INF/pages/products/3");
            String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            File file = new File(basePath, datePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            upload.transferTo(new File(file, filename));

            product.setPimage("products/3/" + datePath + "/" + filename);
        }

        Category category = new Category();
        category.setCid(cid);
        product.setCategory(category);

        Product product1 = productService.findByPid(product.getPid());

        product.setPflag(product1.getPflag());
        product.setPdate(product.getPdate());

        productService.update(product);

        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findByPage(1,8);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("/admin/product/product-list");
        return mv;
    }

    @RequestMapping("/pushDownUI")
    public  ModelAndView pushDownUI(){
        List<Product> list = productService.findByPflag();
        PageInfo pageInfo = new PageInfo(list);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("/admin/product/product-pushDown-list");
        return mv;
    }

    @RequestMapping("/pushDown/{pid}")
    public  ModelAndView pushDown(@PathVariable("pid")String pid,ModelAndView mv){
        Product product = productService.findByPid(pid);
        product.setPflag(1);
        productService.update(product);
        mv.setViewName("/admin/product/product-list");
        return mv;
    }

    @RequestMapping("/pushUp/{pid}")
    public  ModelAndView pushUp(@PathVariable("pid")String pid){
        Product product = productService.findByPid(pid);
        product.setPflag(0);
        productService.update(product);
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findByPage(1,8);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("/admin/product/product-list");
        return mv;
    }

}
