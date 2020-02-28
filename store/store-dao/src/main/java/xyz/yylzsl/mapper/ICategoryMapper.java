package xyz.yylzsl.mapper;

/**
 * 种类持久层
 */
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.yylzsl.pojo.Category;

import java.util.List;

public interface ICategoryMapper {

    @Select("select * from category")
    List<Category> findAll();

    @Select("select * from category where cid = #{cid}")
    Category findByCid(String cid);

    @Insert("insert into category(cid,cname) values(#{cid},#{cname})")
    void save(Category category);

    @Update("update category set cname = #{cname} where cid = #{cid}")
    void update(Category category);

    @Delete("delete from category where cid = #{cid}")
    void delete(String cid);
}
