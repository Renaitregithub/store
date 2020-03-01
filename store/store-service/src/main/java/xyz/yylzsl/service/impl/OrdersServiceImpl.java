package xyz.yylzsl.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yylzsl.mapper.IOrdersMapper;
import xyz.yylzsl.pojo.OrderItem;
import xyz.yylzsl.pojo.Orders;
import xyz.yylzsl.pojo.User;
import xyz.yylzsl.service.IOrdersService;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersMapper mapper;

    @Override
    public void save(Orders orders) {
        mapper.saveOrders(orders);
        for (OrderItem orderItem : orders.getList()) {
            mapper.saveOrderItem(orderItem);
        }
    }





    @Override
    public List<Orders> findByUid(User loginUserSession, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Orders> list = mapper.findByOrdersUid(loginUserSession);
        return list;
    }

    @Override
    public Orders findByOid(String oid) {
        Orders orders = mapper.findByOrdersOid(oid);
        List<OrderItem> orderItem = mapper.findByOrderItemOid(orders);
        for (OrderItem item : orderItem) {
            orders.getList().add(item);
        }
        return orders;
    }

    @Override
    public void update(Orders ordersPay) {
        mapper.update(ordersPay);
    }

    @Override
    public List<Orders> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return mapper.findAll();
    }

    @Override
    public List<Orders> findByState(Integer state,Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return mapper.findByState(state);
    }

    @Override
    public Orders findDetail(String oid) {
        return mapper.findByOrdersOid(oid);
    }
}
