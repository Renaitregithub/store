package xyz.yylzsl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.yylzsl.service.IOrderItemService;
import xyz.yylzsl.service.IOrdersService;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private IOrderItemService service;


}
