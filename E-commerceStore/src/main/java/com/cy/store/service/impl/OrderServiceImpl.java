package com.cy.store.service.impl;

import com.cy.store.commons.utils.UUIDUtils;
import com.cy.store.entity.Address;
import com.cy.store.entity.Cart;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.mapper.OrderItemMapper;
import com.cy.store.mapper.OrderMapper;
import com.cy.store.service.AddressService;
import com.cy.store.service.CartService;
import com.cy.store.service.OrderService;
import com.cy.store.service.UserService;
import com.cy.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public Order createOrder(Integer aid, Integer uid, String[] cid, String username) {
        List<Cart> list = cartService.findCartByCidList(cid, uid);
        Long totalPrice=0L;
        Address address = addressService.selectAddressByaid(aid, uid);
        for (Cart c:list) {
            totalPrice += c.getRealPrice() * c.getNum();
        }
        Order order = new Order();
        order.setUid(uid);
        order.setOid(UUIDUtils.getUUID());
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        order.setTotalPrice(totalPrice);
        order.setOrderTime(new Date());
        order.setCreatedTime(new Date());
        order.setCreatedUser(username);
        order.setModifiedTime(new Date());
        order.setModifiedUser(username);
        order.setStatus(0);
        //插入订单
        Integer integer = orderMapper.insertOrder(order);
        if (integer!=1){
            throw new InsertException("插入时出现未知的异常");
        }
        OrderItem orderItem=null;
        for (Cart c:list){
            orderItem=new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setPid(c.getPid());
            orderItem.setPid(c.getPid());
            orderItem.setTitle(c.getTitle());
            orderItem.setImage(c.getImage());
            orderItem.setPrice(c.getPrice());
            orderItem.setNum(c.getNum());
            orderItem.setCreatedTime(new Date());
            orderItem.setCreatedUser(c.getCreatedUser());
            orderItem.setModifiedTime(new Date());
            orderItem.setModifiedUser(c.getModifiedUser());
            //插入订单项
            Integer rows = orderItemMapper.insertOrderItem(orderItem);
            if (rows!=1){
                throw new InsertException("插入时出现未知的异常");
            }
        }

        return order;
    }
}
