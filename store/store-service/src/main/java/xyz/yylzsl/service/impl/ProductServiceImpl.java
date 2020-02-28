package xyz.yylzsl.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yylzsl.mapper.IProductMapper;
import xyz.yylzsl.pojo.Product;
import xyz.yylzsl.service.IProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductMapper mapper;

    @Override
    public List<Product> findByNew() throws Exception {
        return mapper.findByNew();
    }

    @Override
    public List<Product> findByHot() throws Exception {
        return mapper.findByHot();
    }

    @Override
    public Product findByPid(String pid) {
        return mapper.findById(pid);
    }

    @Override
    public List<Product> findByPageCid(String cid, int page, int size) {
        PageHelper.startPage(page,size);
        return mapper.findByPageCid(cid);
    }

    @Override
    public List<Product> findByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return mapper.findByPage();
    }

    @Override
    public void save(Product product) {
        mapper.save(product);
    }
}
