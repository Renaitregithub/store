package xyz.yylzsl.service;


import xyz.yylzsl.pojo.Category;

import java.util.List;

/**
 * 种类业务层
 */
public interface ICategoryService {

    // List<Category> findByAjax() throws Exception;
    List<Category> findAll()throws Exception;

    void save(Category category);

    Category findByCid(String cid);

    void update(Category category);

    void delete(String cid);
}
