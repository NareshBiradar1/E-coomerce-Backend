package com.scaler.apr2.Controllers;

import com.scaler.apr2.Models.Category;
import com.scaler.apr2.Models.Product;
import com.scaler.apr2.Services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testValidProductId() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Category Title");


        Product product = new Product();
        product.setId(1L);
        product.setTitle("Product Title");
        product.setDescription("Product Description");
        product.setPrice(12.34);
        product.setImageURL("Product Image");
        product.setCategory(category);

        when(productService.getSingleProduct(1L)).thenReturn(product);

        Product output = productController.getProductByID(1L);
        assertEquals(product, output);
    }
}
