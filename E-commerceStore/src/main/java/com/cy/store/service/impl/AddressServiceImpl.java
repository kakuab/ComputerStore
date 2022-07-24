package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.service.AddressService;
import com.cy.store.service.DistrictService;
import com.cy.store.service.ex.*;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private DistrictService districtService;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public List<Address> queryById(Integer uid) {
        return addressMapper.queryById(uid);
    }

    @Override
    public void setDefaultAddress(Integer aid, Integer uid, String modifiedUser) {
        Address result = addressMapper.queryAddressByAid(aid);
        if (result==null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        //如果检测到当前获取的地址不属于用户
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        //设置非默认地址
        Integer nonDefault = addressMapper.updaterNonDefault(uid);
        if (nonDefault < 1){
            throw new UpdateException("更新时产生未知的异常");
        }
        //将某条数据设置为默认地址
        Integer defaultByAid = addressMapper.updateDefaultByAid(aid, modifiedUser, new Date());
        if (defaultByAid!=1){
            throw new UpdateException("更新时产生未知的异常");
        }

    }

    @Override
    public void deleteAddress(Integer uid, Integer aid, String modifiedUser) {
        Address result = addressMapper.queryAddressByAid(aid);
        if (result==null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        //如果检测到当前获取的地址不属于用户
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = addressMapper.deleteAddressByAid(aid);
        if (rows !=1){
            throw new DeleteException("删除数据时产生未知的异常");
        }
        Integer count = addressMapper.countById(uid);
        if (count <0){
            return;
        }
        if (result.getIsDefault()==0){
            return;
        }
        Address address = addressMapper.queryLastAddressByUid(uid);
        rows = addressMapper.updateDefaultByAid(address.getAid(), modifiedUser, new Date());
        if (rows!=1){
            throw new UpdateException("更新数据时出现未知的异常");
        }

    }

    @Override
    public Address selectAddressByaid(Integer aid,Integer uid) {

        Address address = addressMapper.queryAddressByAid(aid);
        if (address==null){
            throw new AddressNotFoundException("地址不存在");
        }
        if (!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法访问数据");
        }
        address.setCityCode(null);
        address.setProvinceCode(null);
        address.setAreaCode(null);
        address.setCreatedUser(null);
        address.setCreatedTime(null);
        address.setModifiedTime(null);
        address.setModifiedUser(null);
        return address;
    }

    @Override
    public void inserAddress(Integer uid,String username,Address address) {
        Integer count = addressMapper.countById(uid);
        if (count >= maxCount){
            throw new AddressCountLimitException("收货地址总数超出限制");
        }
        String provinceName = districtService.queryNameByCode(address.getProvinceCode());
        String cityName = districtService.queryNameByCode(address.getCityCode());
        String areaName = districtService.queryNameByCode(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);
        Integer IsDefault= count==0 ?1:0;
        address.setIsDefault(IsDefault);
        address.setModifiedUser(username);
        address.setCreatedUser(username);
        address.setModifiedTime(new Date());
        address.setCreatedTime(new Date());
        address.setUid(uid);
        Integer rows = addressMapper.insertAddress(address);
        if (rows != 1){
            throw new InsertException("插入时产生未知的异常");
        }
    }
}
