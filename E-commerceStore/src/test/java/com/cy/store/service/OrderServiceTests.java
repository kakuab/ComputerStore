package com.cy.store.service;

import com.cy.store.entity.District;
import com.cy.store.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 标注当前的类是一个测试类，不会随同项目一块打包
 * @RunWith 单元测试类，没有启动不了，参数必须传的是SpringRunner.class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void insert(){
        String[] cid={"1","2","3"};
        Order zhangsan = orderService.createOrder(6, 11, cid, "zhangsan");
        System.out.println(zhangsan);
    }



}