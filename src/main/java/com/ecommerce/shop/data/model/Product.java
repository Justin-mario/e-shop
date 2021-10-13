package com.ecommerce.shop.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(length = 500)
    private String details;
    @ElementCollection
    private List<String> imageUrl;

    @OneToMany(fetch=FetchType.EAGER)
    private List<Feedback> feedbacks;

}
