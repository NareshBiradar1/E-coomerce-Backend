package com.scaler.apr2.Models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long id;

    private String title;

    private double Price;

    private Category category ;

    private String description;

    private String imageURL ;
}
