package xyz.yylzsl.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.yylzsl.pojo.Admin;

public interface IAdminMapper {

    @Select("select * from admin where username=#{username} and password =#{password}")
    Admin login(Admin admin);

    @Update("update admin set username=#{username},password=#{password},email=#{email},telephone=#{telephone},lasttime=#{lasttime},img=#{img} where id = #{id}")
    void update(Admin admin);

    @Select("select * from admin where id=#{id}")
    Admin findById(String id);
}
