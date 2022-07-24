package com.cy.store.service;

import com.cy.store.entity.User;

public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    void register(User user);

    /**
     * 用户登录功能
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);

    /**
     *
     * @param uid 用户id
     * @param username 用户名称
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    void changePassword(Integer uid,String username,String oldPassword,String newPassword);

    /**
     * 根据用户id查询信息
     * @param uid
     * @return
     */
    User getUserByid(Integer uid);

    /**
     * 修改用户信息
     * @param uid
     * @param username
     * @param user
     */
    void updateUser(Integer uid,String username,User user);

    /**
     * 根据用户uid修改头像
     * @param uid
     * @param avatar 头像的路径
     */
    void impportAvatar(Integer uid,String username,String avatar);
}
