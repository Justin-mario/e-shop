package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static  org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;


@Slf4j
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productServiceImpl;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl ();
        MockitoAnnotations.openMocks ( this );
    }

    @Test
    void saveProductMockTest(){
        Product product = new Product ();
        when ( productServiceImpl.save ( product ) ).thenReturn ( product );
        productServiceImpl.save ( product );
        log.info ( "Product after Saving -> {}", product );
        verify ( productRepository, times ( 1 ) ).save ( product );
    }

    @Test
    void updateProductMockTest(){
        Product product = new Product ();
        product.setName ( "Luxury Sofa" );
        product.setPrice ( 400D );
        product.setId ( 100L );
        product.setCurrency ( Currency.NGN );
        product.setDetails ( "The details will be set later" );

        assertThat(product).isNotNull ();
        log.info ( "Product before saving -> {}", product );
        productServiceImpl.save ( product );
        Product savedProduct = productServiceImpl.save ( product );
        log.info ( "Product after Saving -> {}", savedProduct);
        assertThat(savedProduct.getId ()).isNotNull ();
        assertThat ( product.getName () ).isEqualTo ( savedProduct.getName () );
        Long id = product.getId ();

        product.setName ( "New Luxury Sofa" );
        product.setPrice ( 500D );
        product.setCurrency ( Currency.GBP );
        log.info ( "Product before saving -> {}", product );
        productServiceImpl.save ( product );
        log.info ( "Product after Saving -> {}", product );

        when ( productServiceImpl.update (product, id )).thenReturn ( product );
        Product updatedProduct = productServiceImpl.update ( product, id );
//        verify ( updatedProduct, times ( 1 ) ).;
        verify ( updatedProduct.getName ()).equals ( product.getName () );
//        verify ( productRepository, times ( 3 ) ).save ( product );
    }
}