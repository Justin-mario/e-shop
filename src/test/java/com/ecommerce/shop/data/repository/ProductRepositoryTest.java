package com.ecommerce.shop.data.repository;

import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepositoryImpl;
    @BeforeEach
    void setUp() {

    }

    @Test
    public void createdProductTest(){
        Product product = new Product ();
        product.setName ( "Luxury Sofa" );
        product.setPrice ( 400D );
        product.setCurrency ( Currency.NGN );
        product.setDetails ( "The details will be set later" );

        assertThat(product).isNotNull ();
        assertThat(product.getId ()).isNull ();
        log.info ( "Product before saving -> {}", product );
        productRepositoryImpl.save ( product );
        assertThat(product.getId ()).isNotNull ();
        log.info ( "Product after Saving -> {}", product );
    }

    @Test
    @Transactional
    public void whenFindAllProductIsCalledThenProductListIsReturnedTest(){
        List<Product> products = productRepositoryImpl.findAll ();

        assertThat ( products ).hasSize(4);
        log.info ( "Product returned from database -> {}", products );
    }


}