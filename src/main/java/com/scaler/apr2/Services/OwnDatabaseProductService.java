package com.scaler.apr2.Services;

import com.scaler.apr2.CustomExceptions.CategoryNotFoundException;
import com.scaler.apr2.CustomExceptions.ProductNotFoundException;
import com.scaler.apr2.Models.Product;
import com.scaler.apr2.Models.Category;
import com.scaler.apr2.Repository.CategoryRepository;
import com.scaler.apr2.Repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service("OwnDatabasrProductService")
public class OwnDatabaseProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public OwnDatabaseProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts;
    }

    @Override
    public Product getSingleProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }

        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null) { // save the category
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if (optionalCategory.isEmpty()) {
            //The category that is passed in the input product in invalid.
            throw new CategoryNotFoundException("Invalid category id passed");
        }

        product1.setCategory(optionalCategory.get());
        return product1;
    }
}
