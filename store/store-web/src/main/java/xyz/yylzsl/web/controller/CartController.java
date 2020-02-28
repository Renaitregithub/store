package xyz.yylzsl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.yylzsl.pojo.Cart;
import xyz.yylzsl.pojo.Product;
import xyz.yylzsl.service.IProductService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/showPage")
    public  ModelAndView showPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cart");
        return mv;
    }

    @RequestMapping("/addToCart")
    public ModelAndView addToCart(String pid,String quantity,HttpSession session){

        Product product = productService.findByPid(pid);
        Cart cart = getCart(session);
        cart.addCart(product,Integer.parseInt(quantity));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("cart");
        return mv;
    }

    @RequestMapping("/clearCart")
    public ModelAndView clearCart(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Cart cart = getCart(session);
        cart.clearCart();
        mv.setViewName("cart");
        return mv;
    }

    @RequestMapping("/removeCart/{pid}")
    public ModelAndView removeCart(@PathVariable("pid") String pid, HttpSession session){
        ModelAndView mv = new ModelAndView();
        Cart cart = getCart(session);
        cart.removeCart(pid);
        mv.setViewName("cart");
        return mv;
    }

    private Cart getCart(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cartSession");
        if(cart==null){
            cart = new Cart();
            session.setAttribute("cartSession",cart);
        }
        return cart;
    }

}
