package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartMapperTests {

    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(11);
        cart.setPid(10000001);
        cart.setPrice(23L);
        cart.setCreatedUser("zhangsan");
        Integer integer = cartMapper.insertCart(cart);

    }

    @Test
    public void update(){
        /*cartMapper.updateCartByNum(4,1,"管理员",new Date());*/
        Cart cart = cartMapper.queryCartByCidAndPid(10000001, 11);
        System.out.println(cart);
    }

   /* @Test
    public void select(){
        Integer[] cid={1,2,4};
        List<Cart> cartByCidList = cartMapper.findCartByCidList(cid);
        for (Cart c:cartByCidList){
            System.out.println(c);
        }
    }*/
}
