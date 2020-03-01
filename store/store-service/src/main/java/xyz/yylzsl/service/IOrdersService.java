package xyz.yylzsl.service;

import xyz.yylzsl.pojo.Orders;
import xyz.yylzsl.pojo.User;

import java.util.List;

public interface IOrdersService {

    void save(Orders orders);

    List<Orders> findByUid(User loginUserSession, Integer page, Integer pageSize);

    Orders findByOid(String oid);

    void update(Orders ordersPay);

    List<Orders> findAll(Integer page,Integer pageSize);

    List<Orders> findByState(Integer state,Integer page,Integer pageSize);

    Orders findDetail(String oid);
}
