package com.scaler.apr2.Services;

import com.scaler.apr2.Models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getSingleProduct(Long id);

}
