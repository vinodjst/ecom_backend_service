package com.shopee.ecom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;

    private  String description;

    private  double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;



}
