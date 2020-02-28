package xyz.yylzsl.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import xyz.yylzsl.pojo.OrderItem;

public interface IOrderItemMapper {

    @Select("select * from orderitem where oid = #{oid}")
    @Results(  value = {
            @Result(id = true,property ="itemId" ,column ="oitemid" ),
            @Result(property ="quantity" ,column ="quantity" ),
            @Result(property ="total" ,column ="total" ),
            @Result(property ="product" ,column ="pid", one=@One(select = "xyz.yylzsl.mapper.IProductMapper.findById"))}
    )
    OrderItem findByOid(String oid);
}
