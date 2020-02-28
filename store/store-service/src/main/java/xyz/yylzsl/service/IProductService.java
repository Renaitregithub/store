package xyz.yylzsl.service;

import xyz.yylzsl.pojo.Product;

import java.util.List;

/**
 * 产品持久层
 */
public interface IProductService {

    List<Product> findByNew() throws Exception;

    List<Product> findByHot() throws Exception;

    Product findByPid(String pid);

    List<Product> findByPageCid(String cid, int page, int size);

    List<Product> findByPage(Integer page, Integer pageSize);

    void save(Product product);

    void update(Product product);

    List<Product> findByPflag();

}
