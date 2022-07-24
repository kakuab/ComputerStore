package com.cy.store.service;

import com.cy.store.entity.District;

import java.util.List;

public interface DistrictService {
    /**
     * 根据父代码查询区域信息
     * @param parent 父代号
     * @return
     */
    List<District> getByParent(String parent);

    String queryNameByCode(String code);
}
