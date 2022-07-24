package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 标注当前的类是一个测试类，不会随同项目一块打包
 * @RunWith 单元测试类，没有启动不了，参数必须传的是SpringRunner.class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {

    @Autowired
    private AddressService addressService;

    @Test
    public void insert(){
        Address address = new Address();
        address.setAddress("广东省");
        address.setPhone("1243534534");
        address.setName("女朋友");
        addressService.inserAddress(11,"管理员",address);
    }

    @Test
    public void setDefault(){
        addressService.setDefaultAddress(4,11,"管理员");
    }

    @Test
    public void delete(){
        addressService.deleteAddress(11,5,"kakuab");
    }
}