package com.graphql.controller;

import com.graphql.entity.Product;
import com.graphql.repository.ProductRepo;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {
    private ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @QueryMapping
    public List<Product> products(){
        return productRepo.findAll();
    }
    @QueryMapping
    public List<Product> pros(){
        return productRepo.findAll();
    }

}
