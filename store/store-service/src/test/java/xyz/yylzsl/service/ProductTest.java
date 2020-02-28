package xyz.yylzsl.service;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.yylzsl.pojo.Orders;
import xyz.yylzsl.pojo.Product;
import xyz.yylzsl.pojo.User;
import xyz.yylzsl.service.IProductService;

import javax.sound.sampled.Line;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml"})
public class ProductTest {

    @Autowired
    private IProductService productService;
    @Autowired
    private IOrdersService ordersService;


    @Test
    public void testFindByCid(){
        List<Product> list = productService.findByPageCid("1",1, 10);
        System.out.println(list);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
    }

    @Test
    public void testFindByUid(){
        User user = new User();
        user.setUid("f55b7d3a352a4f0782c910b2c70f1ea4");
        List<Orders> list = ordersService.findByUid(user, 1, 10);

        System.out.println(list);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
    }

    @Test
    public  void TestFindByOrdersOid(){
        Orders orders = ordersService.findByOid("77897B45153C40A6969EE7C34EAEE0C0");
        System.out.println(orders);
    }
}
