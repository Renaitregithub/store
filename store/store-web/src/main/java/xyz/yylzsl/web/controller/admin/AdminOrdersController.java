package xyz.yylzsl.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Orders;
import xyz.yylzsl.service.IOrdersService;

import java.util.List;

@Controller
@RequestMapping("/adminOrders")
public class AdminOrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(Integer state){
        ModelAndView mv = new ModelAndView();
        List<Orders> list = null;
        if(state==null){
            list = ordersService.findAll();
        }else{
            list = ordersService.findByState(state);
        }

        mv.addObject("list",list);
        mv.setViewName("admin/order/list");
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
        list = ordersService.findAll();
        mv.addObject("list",list);
        mv.setViewName("admin/order/list");
        return mv;
    }
}
