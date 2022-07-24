package com.cy.store.controller;

import com.cy.store.commons.utils.JsonResult;
import com.cy.store.entity.Cart;
import com.cy.store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController{

    @Autowired
    private CartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> insertCart(HttpSession session,Integer pid,Integer num){
        cartService.insertCart(getUidFromSession(session),getUsernameFromSession(session),pid,num);
        return new JsonResult<>(OK);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<Cart>> queryCart(HttpSession session){
        List<Cart> list = cartService.findCartOnProductByUid(getUidFromSession(session));
        return new JsonResult<>(OK,list);
    }

    @RequestMapping("addnum")
    public JsonResult<Integer> addNum(Integer cid,HttpSession session){
        Integer num = cartService.addNum(cid, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK,num);
    }

    @RequestMapping("list")
    public JsonResult<List<Cart>> getCartList(String[] cid,HttpSession session){
        List<Cart> list = cartService.findCartByCidList(cid, getUidFromSession(session));
        return new JsonResult<>(OK,list);
    }
}
