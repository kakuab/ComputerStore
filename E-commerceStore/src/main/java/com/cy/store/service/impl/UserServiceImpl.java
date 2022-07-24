package com.cy.store.service.impl;


import com.cy.store.commons.utils.Md5Password;
import com.cy.store.commons.utils.UUIDUtils;
import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.UserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void register(User user) {
        String username = user.getUsername();
        User result = userMapper.fingByUserName(username);
        //调用mapper层判断用户名是否被注册过
        if (result != null){
            throw new UsernameDuplicatedException("用户名被占用");
        }

        //获取用户密码
        String oldpassword = user.getPassword();
        //生成盐值
        String salt = UUIDUtils.getUUID();
        //将盐值存入数据库
        user.setSalt(salt);
        //将密码和盐值进行加密
        String md5Password = Md5Password.getPassword(oldpassword, salt);
        //将加密后的密码存入数据库
        user.setPassword(md5Password);

        user.setCreatedTime(new Date());
        user.setCreatedUser(username);
        user.setModifiedTime(new Date());
        user.setModifiedUser(username);
        user.setIsDelete(0);

        //执行用户注册功能
        Integer rows = userMapper.insertUser(user);
        if (rows > 1){
            throw new InsertException("在用户注册过程中产生了位置的异常");
        }
    }

    @Override
    public User login(String username, String password) {

        User result = userMapper.fingByUserName(username);
        //判断是否为空，为空表示用户不存在
        if (result == null){
            throw new UserNotFoundException("用户不存在");
        }
        //判断用户是否被注销 1表示已注销
        if (result.getIsDelete()==1){
            throw new UserNotFoundException("用户不存在");
        }
        //获取加密后的密码
        String oldPassword = result.getPassword();
        //获取注册时的盐值
        String salt = result.getSalt();
        //进行加密
        String md5Password = Md5Password.getPassword(password, salt);
        //判断密码是否正确
        if (!md5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("用户密码错误");
        }
        //将当前用户返回
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public User getUserByid(Integer uid) {
        User result = userMapper.querUserByUid(uid);
        if (result==null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户不存在");
        }
        User user = new User();
        user.setPhone(result.getPhone());
        user.setUsername(result.getUsername());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    @Override
    public void impportAvatar(Integer uid, String username, String avatar) {
        User result = userMapper.querUserByUid(uid);
        if (result==null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if (rows >1){
            throw new UpdateException("更新时产生未知的异常");
        }
    }

    @Override
    public void updateUser(Integer uid, String username, User user) {
        User result = userMapper.querUserByUid(uid);
        if (result==null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateUserById(user);
        if (rows > 1){
            throw new UpdateException("更新用户产生未知的异常");
        }
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.querUserByUid(uid);
        if (result ==null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户不存在");
        }
        //原密码和数据库的密码进行比较
        String salt = UUIDUtils.getUUID();
        String oldMd5Password = Md5Password.getPassword(oldPassword, result.getSalt());
        if (!result.getPassword().equals(oldMd5Password)){
            throw new PasswordNotMatchException("密码错误");
        }
        //加密新密码
        String newMd5Password = Md5Password.getPassword(newPassword, result.getSalt());
        Integer rows=userMapper.updatePasswordByUid(uid,newMd5Password,result.getUsername(),new Date());
        if (rows > 1){
            throw new UpdateException("更新数据产生未知的异常");
        }

    }

}
