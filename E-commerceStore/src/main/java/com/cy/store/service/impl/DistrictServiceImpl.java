package com.cy.store.service.impl;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.queryDistrictByParent(parent);
        for (District d:list){
            d.setId(null);
            d.setParent(null);
        }
        return list;
    }

    @Override
    public String queryNameByCode(String code) {
        return districtMapper.queryNameByCode(code);
    }
}
