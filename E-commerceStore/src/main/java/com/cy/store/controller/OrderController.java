package com.cy.store.controller;

import com.cy.store.commons.utils.JsonResult;
import com.cy.store.entity.Order;
import com.cy.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("orders")
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> createOrder(Integer aid, String[] cid, HttpSession session){
        Order order = orderService.createOrder(aid, getUidFromSession(session), cid, getUsernameFromSession(session));
        return new JsonResult<>(OK,order);
    }
}
