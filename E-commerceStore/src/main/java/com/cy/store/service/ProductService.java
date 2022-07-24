package com.cy.store.service;

import com.cy.store.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> queryHotProduct();

    Product queryProductById(Integer id);
}
