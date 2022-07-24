package com.cy.store.service.impl;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.CartService;
import com.cy.store.service.ex.AccessDeniedException;
import com.cy.store.service.ex.CartNotFoundException;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Cart> findCartOnProductByUid(Integer uid) {
        List<Cart> list = cartMapper.findCartOnProductByUid(uid);
        if (list==null){
            throw new CartNotFoundException("数据不存在");
        }
        return list;
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String modifiedUser) {
        Cart result = cartMapper.queryCartByCid(cid);
        if (result==null){
            throw new CartNotFoundException("数据不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("用户数据非法访问");
        }
        Integer num = result.getNum()+1;
        Integer rows = cartMapper.updateCartByNum(num, cid, modifiedUser, new Date());
        if (rows!=1){
            throw new UpdateException("数据更新时长生未知的异常");
        }
        return num;
    }

    @Override
    public List<Cart> findCartByCidList(String[] cid, Integer uid) {
        List<Cart> list = cartMapper.findCartByCidList(cid);
        Iterator<Cart> it = list.iterator();
        while (it.hasNext()){
            Cart cart = it.next();
            if (!cart.getUid().equals(uid)){
                list.remove(cart);
            }
        }

        return list;
    }

    @Override
    public void insertCart(Integer uid,String modifiedUser,Integer pid,Integer amount) {
        Cart result = cartMapper.queryCartByCidAndPid(pid, uid);
        Integer rows =0;
        if (result==null){
            //如果查询到的购车数据不存在，则新增一条数据
            //补全数据
            Cart cart = new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            //获取商品的价格
            Product product = productMapper.queryProductById(pid);
            cart.setPrice(product.getPrice());
            cart.setCreatedUser(modifiedUser);
            cart.setCreatedTime(new Date());
            cart.setModifiedUser(modifiedUser);
            cart.setModifiedTime(new Date());
            //插入数据库
            rows = cartMapper.insertCart(cart);
            if (rows!=1){
                throw new InsertException("插入数据时产生未知的异常");
            }
        }else {
            //如果商品在购物车存在，则修改num值
            Integer num=result.getNum()+amount;
            rows = cartMapper.updateCartByNum(num, result.getCid(), modifiedUser, new Date());
            if (rows!=1){
                throw new UpdateException("更新数据时产生未知的异常");
            }
        }
    }
}
