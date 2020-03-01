package xyz.yylzsl.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import xyz.yylzsl.mapper.ICategoryMapper;
import xyz.yylzsl.pojo.Category;
import xyz.yylzsl.pojo.Product;
import xyz.yylzsl.service.ICategoryService;
import xyz.yylzsl.utils.JedisUtils;
import xyz.yylzsl.utils.JsonUtil;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryMapper categoryMapper;


    @Override
    public List<Category> findAll(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return categoryMapper.findAll();
    }

    @Override
    public void save(Category category) {
        categoryMapper.save(category);
    }

    @Override
    public Category findByCid(String cid) {
        return categoryMapper.findByCid(cid);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void delete(String cid) {
        categoryMapper.delete(cid);
    }
}
