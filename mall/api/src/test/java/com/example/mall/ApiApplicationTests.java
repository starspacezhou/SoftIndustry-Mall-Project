package com.example.mall;

import com.example.mall.dao.*;
import com.example.mall.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = ApiApplication.class)
@RunWith(SpringRunner.class)
class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCommentsMapper productCommentsMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    void contextLoads() {
        // 分类列表测试
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories2(0);
        for (CategoryVO c1 : categoryVOS) {
            System.out.println(c1);
            for (CategoryVO c2 : c1.getCategories()) {
                System.out.println("\t" + c2);
                for (CategoryVO c3 : c2.getCategories()) {
                    System.out.println("\t\t" + c3);
                }
            }
        }
    }

    @Test
    public void testRecommend() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        for (ProductVO p : productVOS) {
            System.out.println(p);
        }
    }

    @Test
    public void testSelectFirstLevelCategory() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        for (CategoryVO c : categoryVOS) {
            System.out.println(c);
        }
    }

    @Test
    public void testSelectComments() {
        List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectCommentsByProductId("3", 0, 1);
        for (ProductCommentsVO p : productCommentsVOS) {
            System.out.println(p);
        }
    }

    @Test
    public void testShoppingCart() {
        List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.selectShoppingCartByUserId(1);
        System.out.println(shoppingCartVOS);
    }

    @Test
    public void testShoppingCarts() {
        String cids = "5,8";
        String arr[] = cids.split(",");
        List<Integer> cidsList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cidsList.add(Integer.parseInt(arr[i]));
        }
        List<ShoppingCartVO> list = shoppingCartMapper.selectShoppingCartByCartIds(cidsList);
        for (ShoppingCartVO s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testSchedule() {
        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", "1");
        Date time = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
        criteria.andLessThan("createTime", time);

        List<Orders> orders = ordersMapper.selectByExample(example);
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getOrderId() + "\t" + orders.get(i).getCreateTime() + "\t" + orders.get(i).getStatus());
        }
    }
}
