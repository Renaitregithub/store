package xyz.yylzsl.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import xyz.yylzsl.pojo.Product;

import java.util.List;

/**
 * 商品持久层
 */
public interface IProductMapper {


    @Select("select * from product where is_hot = 1 and pflag = 0 order by pdate desc limit 9")
    @ResultMap("productMap")
    List<Product> findByHot() throws Exception;

    @Select("select * from product where pflag = 0 order by pdate desc limit 9")
    @ResultMap("productMap")
    List<Product> findByNew()throws Exception;

    @Select("select * from product where pid = #{pid}")
    @Results(id="productMap",value={
            @Result(column="cid",property="category",one = @One(select = "xyz.yylzsl.mapper.ICategoryMapper.findByCid",fetchType = FetchType.EAGER))
        }
    )
    Product findById(String pid);

    @Select("select * from product")
    @ResultMap("productMap")
    List<Product> findAll();

    @Select("select * from product where cid = #{cid}")
    @ResultMap("productMap")
    List<Product> findByPageCid(String cid);

    @Select("select * from product where pflag = 0 order by pdate desc")
    List<Product> findByPage();

    @Insert("insert into product(pid,pname,shop_price,market_price,pimage,pdate,is_hot,pdesc,pflag,cid) values(#{pid},#{pname},#{shop_price},#{market_price},#{pimage},#{pdate},#{is_hot},#{pdesc},#{pflag},#{category.cid})")
    void save(Product product);

    @Update("update product set pname=#{pname},shop_price=#{shop_price},market_price=#{market_price},pimage=#{pimage},pdate=#{pdate},is_hot=#{is_hot},pdesc=#{pdesc},pflag=#{pflag},cid=#{category.cid} where pid = #{pid}")
    void update(Product product);

    @Select("select * from product where pflag = 1 order by pdate desc")
    List<Product> findByPflag();
}
