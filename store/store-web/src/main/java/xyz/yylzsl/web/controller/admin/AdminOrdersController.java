package xyz.yylzsl.web.controller.admin;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Orders;
import xyz.yylzsl.service.IOrdersService;

import java.util.List;

@Controller
@RequestMapping("/adminOrders")
public class AdminOrdersController {

    @Autowired
    private IOrdersService ordersService;

    @ModelAttribute
    public ModelAndView before(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name="pageSize",required = true,defaultValue = "6")Integer pageSize,Integer state){
        ModelAndView mv = new ModelAndView();
        List<Orders> list = null;
        PageInfo pageInfo = null;
        if(state==null){
            list = ordersService.findAll(page,pageSize);
            pageInfo = new PageInfo(list);
        }else{
            list = ordersService.findByState(state,page,pageSize);
            pageInfo = new PageInfo(list);
        }
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView mv){
        mv.setViewName("admin/orders/orders-list");
        return mv;
    }

    @RequestMapping("/showDetail")
    @ResponseBody
    public Orders showDetail(String oid){
        Orders items = ordersService.findDetail(oid);
        return items;
    }

    @RequestMapping("/sendGoods/{oid}")
    public ModelAndView sendGoods(@PathVariable("oid") String oid){
        Orders orders = ordersService.findByOid(oid);
        orders.setState(3);
        ordersService.update(orders);

        ModelAndView mv = new ModelAndView();
        List<Orders> list = null;
        list = ordersService.findAll(1,6);
        mv.addObject("list",list);
        mv.setViewName("admin/orders/orders-list");
        return mv;
    }
}
