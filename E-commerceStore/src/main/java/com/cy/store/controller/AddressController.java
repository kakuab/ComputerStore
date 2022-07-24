package com.cy.store.controller;

import com.cy.store.commons.utils.JsonResult;
import com.cy.store.entity.Address;
import com.cy.store.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController{

    @Autowired
    private AddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(HttpSession session, Address address){
        addressService.inserAddress(getUidFromSession(session),getUsernameFromSession(session),address);
        return new JsonResult<>(OK);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<Address>> selectUserAddress(HttpSession session){
        List<Address> addresses = addressService.queryById(getUidFromSession(session));
        return new JsonResult<>(OK,addresses);
    }

    @RequestMapping("set_default")
    public JsonResult<Void> setDefault(HttpSession session,Integer aid){
        addressService.setDefaultAddress(aid,getUidFromSession(session),getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("delete")
    public JsonResult<Void> deleteAddress(Integer aid,HttpSession session){
        addressService.deleteAddress(getUidFromSession(session),aid,getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
}
