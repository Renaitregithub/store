package xyz.yylzsl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yylzsl.mapper.IOrderItemMapper;
import xyz.yylzsl.service.IOrderItemService;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

    @Autowired
    private IOrderItemMapper mapper;

}
