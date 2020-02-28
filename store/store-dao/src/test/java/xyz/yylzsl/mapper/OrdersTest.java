package xyz.yylzsl.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.yylzsl.pojo.OrderItem;
import xyz.yylzsl.pojo.Orders;
import xyz.yylzsl.pojo.User;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml"})
public class OrdersTest {

    @Autowired
    private IOrdersMapper mapper;

    @Test
    public void TestFindByOrdersUid(){
        User user = new User();
        user.setUid("f55b7d3a352a4f0782c910b2c70f1ea4");
        System.out.println("++++++++++++++");
        List<Orders> list = mapper.findByOrdersUid(user);
        System.out.println(list);
        System.out.println("++++++++++++++");
        for (Orders orders : list) {
            List<OrderItem> list1 = orders.getList();
            for (OrderItem orderItem : list1) {
                System.out.println(orderItem);
            }
        }
    }
}
