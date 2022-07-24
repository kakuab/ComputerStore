package com.cy.store.controller;

import com.cy.store.commons.utils.JsonResult;
import com.cy.store.entity.District;
import com.cy.store.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("district")
public class DistrictController extends BaseController{

    @Autowired
    private DistrictService districtService;

    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> byParent = districtService.getByParent(parent);
        return new JsonResult<>(OK,byParent);
    }
}
