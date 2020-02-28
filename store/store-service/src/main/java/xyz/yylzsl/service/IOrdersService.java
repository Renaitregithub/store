package xyz.yylzsl.service;

import xyz.yylzsl.pojo.Orders;
import xyz.yylzsl.pojo.User;

import java.util.List;

public interface IOrdersService {

    void save(Orders orders);

    List<Orders> findByUid(User loginUserSession, Integer page, Integer pageSize);

    Orders findByOid(String oid);

    void update(Orders ordersPay);

    List<Orders> findAll();

    List<Orders> findByState(Integer state);

    Orders findDetail(String oid);
}
