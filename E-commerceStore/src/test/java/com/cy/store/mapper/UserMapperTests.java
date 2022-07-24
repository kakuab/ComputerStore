package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 标注当前的类是一个测试类，不会随同项目一块打包
 * @RunWith 单元测试类，没有启动不了，参数必须传的是SpringRunner.class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("123");
        Integer insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void query(){
        User lisi = userMapper.fingByUserName("lisi");
        System.out.println(lisi);
    }

    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(7,"321","管理员",new Date());
    }

    @Test
    public void updateUserById(){
        User user = new User();
        user.setUid(11);
        user.setPhone("1111232131");
        user.setEmail("123@qq.com");
        user.setGender(1);
        userMapper.updateUserById(user);
    }
}
