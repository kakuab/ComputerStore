package com.cy.store.service;

import com.cy.store.entity.Cart;

import java.util.List;

public interface CartService {

    void insertCart(Integer uid,String modifiedUser,Integer pid,Integer amount);

    List<Cart> findCartOnProductByUid(Integer uid);

    Integer addNum(Integer cid,Integer uid,String modifiedUser);

    List<Cart> findCartByCidList(String[] cid,Integer uid);
}
