package com.cy.store.service;

import com.cy.store.entity.Address;

import java.util.List;

public interface AddressService {

    void inserAddress(Integer uid,String username,Address address);

    List<Address> queryById(Integer uid);

    /**
     * 设置用户的默认地址
     * @param aid
     * @param uid
     * @param modifiedUser
     */
    void setDefaultAddress(Integer aid,Integer uid,String modifiedUser);

    /**
     * 删除用户选中的收货地址
     * @param uid
     * @param aid
     * @param modifiedUser
     */
    void deleteAddress(Integer uid,Integer aid,String modifiedUser);

    Address selectAddressByaid(Integer aid,Integer uid);
}
