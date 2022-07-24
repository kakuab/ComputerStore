package com.cy.store.controller;

import com.cy.store.commons.utils.JsonResult;
import com.cy.store.entity.Product;
import com.cy.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController extends BaseController{

    @Autowired
    private ProductService productService;

    @RequestMapping("hot_product")
    public JsonResult<List<Product>> getHotProduct(){
        List<Product> products = productService.queryHotProduct();
        return new JsonResult<>(OK,products);
    }

    @RequestMapping("details")
    public JsonResult<Product> getByid(Integer id){
        Product product = productService.queryProductById(id);
        return  new JsonResult<>(OK,product);
    }
}
