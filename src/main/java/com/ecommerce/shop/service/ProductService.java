package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product update(Product product, Long id);
    List<Product> findAll();
    Product findById(Long id);
    void deleteById(Long id);
}
