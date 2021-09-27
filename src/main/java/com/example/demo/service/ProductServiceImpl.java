package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dao.Cart;
import com.example.demo.dao.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    private TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
    };

    public Product getProductById(int pid) {
        List<Product> products = load();
        if(products.size() == 0){
            return null;
        }
        for (Product p : products) {
            if (p.getId().equals(pid)) {
                return p;
            }
        }
        return null;
    }


    @Override
    public List<Product> findAll() {
        List<Product> products = load();
        return products;

    }

    public List<Product> getProductByCategory(String category) {
        List<Product> products = load();
        if(products.size() == 0){
            return new ArrayList<>();
        }

        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> load() {
        ObjectMapper mapper = new ObjectMapper();

        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/json/products.json");
        List<Product> products = new ArrayList<>();
        try {
            products = mapper.readValue(inputStream, typeReference);
            log.info("Products Saved!");
        } catch (IOException e) {
            log.error("Unable to save products: " + e.getMessage());
        }
        return products;
    }
}
