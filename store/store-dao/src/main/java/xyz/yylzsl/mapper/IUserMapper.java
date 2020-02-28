package xyz.yylzsl.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.yylzsl.pojo.User;


/**
 * 用户持久层
 */
public interface IUserMapper {

    @Insert("insert into user(uid,username,password,name,sex,birthday,email,telephone,state,code) values(#{uid},#{username},#{password},#{name},#{sex},#{birthday},#{email},#{telephone},#{state},#{code})")
    void save(User user) throws Exception;

    @Select("select * from user where code = #{code}")
    User findByCode(String code) throws Exception;

    @Update("update user set username = #{username}, password = #{password}, name = #{name}, sex = #{sex}, birthday = #{birthday},email = #{email},telephone = #{telephone},state = #{state},code = #{code} where uid = #{uid}")
    void update(User user);

    @Select("select * from user where username = #{username} and password = #{password} and state = 1")
    User findByUserAndPassword(User user) throws Exception;

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Select("select * from user where uid = #{uid}")
    User findByUid(String uid);
}
