package xyz.yylzsl.web.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.*;
import xyz.yylzsl.service.IOrdersService;
import xyz.yylzsl.utils.PaymentUtil;
import xyz.yylzsl.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService service;

    @RequestMapping("/saveOrder")
    public ModelAndView saveOrder(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Cart cartSession = (Cart) session.getAttribute("cartSession");
        User loginUserSession = (User) session.getAttribute("loginUserSession");
        if(loginUserSession==null){
            mv.addObject("msg","请先登录，在继续购买");
            mv.setViewName("login");
            return mv;
        }

        Orders orders = new Orders();
        orders.setOid(UUIDUtils.getCode());
        orders.setState(1);
        orders.setOrderTime(new Date());
        orders.setTotal(cartSession.getTotal());
        orders.setUser(loginUserSession);

        for (CartItem cartItem : cartSession.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemId(UUIDUtils.getCode());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotal(cartItem.getTotal());
            orderItem.setOrders(orders);
            orders.getList().add(orderItem);
        }

        service.save(orders);
        cartSession.clearCart();
        mv.addObject("orders",orders);
        mv.setViewName("order_info");
        return mv;
    }






    @RequestMapping("/findByUid/{uid}")
    public ModelAndView findByUid(@PathVariable("uid")String uid, @RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "pageSize",required = true,defaultValue = "3")Integer pageSize,HttpSession session){
        ModelAndView mv = new ModelAndView();
        User loginUserSession = (User) session.getAttribute("loginUserSession");
        List<Orders> list = service.findByUid(loginUserSession, page, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("uid",uid);
        mv.setViewName("order_list");
        return mv;
    }

    @RequestMapping("/findByOid/{oid}")
    public ModelAndView findByOid(@PathVariable("oid")String oid){
        ModelAndView mv = new ModelAndView();
        Orders orders = service.findByOid(oid);

        mv.addObject("orders",orders);
        System.out.println(orders);
        mv.setViewName("order_info");
        return mv;
    }

    @RequestMapping("/payOrder")
    public String payOrder(Orders orders, String pd_FrpId, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        Orders ordersPay = service.findByOid(orders.getOid());
        ordersPay.setName(orders.getName());
        ordersPay.setTelephone(orders.getTelephone());
        ordersPay.setAddress(orders.getAddress());

        service.update(ordersPay);

        //支付流程
        // 把付款所需要的参数准备好:
        String p0_Cmd = "Buy";
        //商户编号
        String p1_MerId = "10001126856";
        //订单编号
        String p2_Order = orders.getOid();
        //金额
        String p3_Amt = ordersPay.getTotal().toString();
        //币种
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        //接受响应参数的Servlet
        String p8_Url = "http://localhost:8080/"+request.getContextPath()+"/order/callback";
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        //公司的秘钥
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

        //调用易宝的加密算法,对所有数据进行加密,返回电子签名
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);

        return "redirect:/"+sb.toString();
    }

    @RequestMapping("/callback")
    public ModelAndView callback(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        String r6_Order = request.getParameter("r6_Order");
        String r3_Amt = request.getParameter("r3_Amt3");

        Orders orders = service.findByOid(r6_Order);
        orders.setState(2);
        service.update(orders);
        request.setAttribute("msg","请！你已经成功付款成！订单号为："+r6_Order+"支付金额为："+r3_Amt);
        mv.setViewName("info");
        return mv;
    }
}
