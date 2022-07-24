package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
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
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void insert() {

        try {
            User user = new User();
            user.setUsername("lisi2");
            user.setPassword("123");
            userService.register(user);
            System.out.println("ok");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void login() {
        User zhangsan = userService.login("zhangsan", "123");
        System.out.println(zhangsan);
    }

    @Test
    public void changePassword() {
        userService.changePassword(11, "zhangsan", "321", "123");
    }

    @Test
    public void chageUser() {
        User user = new User();
        user.setPhone("13450159187");
        user.setEmail("134324@qq.com");
        user.setGender(0);
        userService.updateUser(11, "管理员", user);
    }

    @Test
    public void exportAvatar(){
        userService.impportAvatar(11,"管理员","C://kakuab/touxiang");
    }
}