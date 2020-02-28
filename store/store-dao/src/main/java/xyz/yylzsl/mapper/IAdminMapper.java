package xyz.yylzsl.mapper;

import org.apache.ibatis.annotations.Select;
import xyz.yylzsl.pojo.Admin;

public interface IAdminMapper {

    @Select("select * from admin where username=#{username} and password =#{password}")
    Admin login(Admin admin);

}
