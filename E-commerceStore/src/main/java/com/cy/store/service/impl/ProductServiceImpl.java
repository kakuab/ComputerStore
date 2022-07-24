package com.cy.store.service.impl;

import com.cy.store.entity.Product;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ProductService;
import com.cy.store.service.ex.ProductNotFoundException;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> queryHotProduct() {
        return productMapper.queryHotProduct();
    }

    @Override
    public Product queryProductById(Integer id) {
        Product product = productMapper.queryProductById(id);
        if (product==null){
            throw new ProductNotFoundException("商品查询异常");
        }

        return product;
    }
}
