package com.scaler.apr2.Services;

import com.scaler.apr2.CustomExceptions.ProductNotFoundException;
import com.scaler.apr2.DTO.FakeStoreProductDto;
import com.scaler.apr2.Models.Category;
import com.scaler.apr2.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com/products/";

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(url,FakeStoreProductDto[].class);
        List<Product> allProducts = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            allProducts.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return allProducts;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(url+id,FakeStoreProductDto.class);
        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException(id,"Product NOT FOUND");
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }



    public Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();

        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageURL(fakeStoreProductDto.getImageURL());

        return product;
    }


}
