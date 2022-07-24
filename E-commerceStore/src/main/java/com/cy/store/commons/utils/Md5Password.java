package com.cy.store.commons.utils;

import org.apache.tomcat.util.digester.Digester;
import org.springframework.util.DigestUtils;

/**
 * md5加密密码工具类
 */
public class Md5Password {
    public static String getPassword(String password,String salt){
        for (int i = 1; i < 3; i++) {
            password=DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
