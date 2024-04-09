package com.scaler.apr2.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    private Long id;

    private String title;

    private double Price;

    @ManyToOne
    private Category category ;

    private String description;

    private String imageURL ;
}
