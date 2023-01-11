package com.graphql;

import com.graphql.entity.Category;
import com.graphql.entity.Product;
import com.graphql.repository.CategoryRepo;
import com.graphql.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class GraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepo categoryRepo, ProductRepo productRepo) {
        return args -> {
            Random random = new Random();
            Category category=new Category(null, "Computer", null);
            Category category1=new Category(null, "Printer", null);
            Category category2=new Category(null, "Smartphone", null);
            categoryRepo.save(category);
            categoryRepo.save(category1);
            categoryRepo.save(category2);

            List<Category> categories = categoryRepo.findAll();
            categories.forEach(cat -> {
                for(int i=0; i<5; i++){
                    productRepo.save(new Product(UUID.randomUUID().toString(), "product-"+(i+1), Math.random()*5000, random.nextInt(100), cat));
                }
            });
        };
    }
}
