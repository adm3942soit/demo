package com.example.demo.facades;

import java.util.List;

import com.example.demo.dao.Product;

public interface ProductServiceFacade {
    List<Product> findAll();
    Product getProductById(int pid);
    List<Product> getProductByCategory(String category);
}
