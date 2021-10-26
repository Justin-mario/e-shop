package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product save(Product product) {
        return  productRepository.save ( product );
    }

    @Override
    public Product update(Product newProduct, Long id) {
        return productRepository.findById(id)
                .map( product -> {
                    product.setName (newProduct.getName());
                    product.setPrice (newProduct.getPrice ());
                    product.setCurrency ( newProduct.getCurrency () );
                    product.setDetails ( newProduct.getDetails () );
                    return productRepository.save( product );
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll ();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById ( id ).orElse ( null );
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById ( id );
    }
}
