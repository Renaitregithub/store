package xyz.yylzsl.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.core.annotation.Order;
import xyz.yylzsl.pojo.Cart;
import xyz.yylzsl.pojo.OrderItem;
import xyz.yylzsl.pojo.Orders;
import xyz.yylzsl.pojo.User;

import java.util.List;

public interface IOrdersMapper {

    @Insert("insert into orders(oid,orderTime,total,state,address,name,telephone,uid) values(#{oid},#{orderTime},#{total},#{state},#{address},#{name},#{telephone},#{user.uid})")
    void saveOrders(Orders orders);

    @Insert("insert into orderItem(itemId,quantity,total,pid,oid) values(#{itemId},#{quantity},#{total},#{product.pid},#{orders.oid})")
    void saveOrderItem(OrderItem orderItem);





    @Select("select * from orders where uid = #{uid} order by orderTime desc")
    @Results(id = "ordersMapper",value = {
            @Result(id=true, property = "oid",column = "oid"),
            @Result(property = "orderTime",column = "ordertime"),
            @Result(property = "total",column = "total"),
            @Result(property = "state",column = "state"),
            @Result(property = "address",column = "address"),
            @Result(property = "name",column = "name"),
            @Result(property = "telephone",column = "telephone"),
            @Result(property = "user",column = "uid", one = @One(select = "xyz.yylzsl.mapper.IUserMapper.findByUid",fetchType = FetchType.EAGER)),
            @Result(property = "list",column = "oid", many = @Many(select = "xyz.yylzsl.mapper.IOrdersMapper.findByOrderItemOid",fetchType = FetchType.EAGER))
    })
    List<Orders> findByOrdersUid(User loginUserSession);

    @Select("select * from orderItem where oid = #{oid}")
    @Results(id = "orderItemMapper",value = {
            @Result(id=true, property = "itemId",column = "itemId"),
            @Result(property = "quantity",column = "quantity"),
            @Result(property = "total",column = "total"),
            @Result(property = "product",column = "pid", one = @One(select = "xyz.yylzsl.mapper.IProductMapper.findById",fetchType = FetchType.EAGER))
    })
    List<OrderItem> findByOrderItemOid(Orders orders);


    @Select("select * from orders where oid = #{oid}")
    @Results(value = {
            @Result(id=true, property = "oid",column = "oid"),
            @Result(property = "orderTime",column = "ordertime"),
            @Result(property = "total",column = "total"),
            @Result(property = "state",column = "state"),
            @Result(property = "address",column = "address"),
            @Result(property = "name",column = "name"),
            @Result(property = "telephone",column = "telephone"),
            @Result(property = "user",column = "uid", one = @One(select = "xyz.yylzsl.mapper.IUserMapper.findByUid",fetchType = FetchType.EAGER)),
            @Result(property = "user",column = "uid", one = @One(select = "xyz.yylzsl.mapper.IUserMapper.findByUid",fetchType = FetchType.EAGER)),
    })
    Orders findByOrdersOid(String oid);

    @Update("update orders set total=#{total},state=#{state},address=#{address},name=#{name},telephone=#{telephone} where oid = #{oid}")
    void update(Orders ordersPay);

    @Select("select * from orders where state = #{state} order by oderTime desc")
    List<Orders> findByState(Integer state);

    @Select("select * from orders order by oderTime desc")
    List<Orders> findAll();

//    List<OrderItem> findDetail(String oid);
}
