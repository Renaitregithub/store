package xyz.yylzsl.mapper;

import org.apache.ibatis.annotations.Select;
import xyz.yylzsl.pojo.OrderItem;

public interface IOrderItemMapper {

    @Select("select * from orderitem where oid = #{oid}")
    OrderItem findByOid(String oid);
}
