package com.cy.store.service;

import com.cy.store.entity.Order;

public interface OrderService {

    /**
     * 创建订单
     * @param aid 地址id
     * @param uid 用户id
     * @param cid 购物车id
     * @param username 用户
     * @return
     */
    Order createOrder(Integer aid, Integer uid, String[] cid, String username);
}
