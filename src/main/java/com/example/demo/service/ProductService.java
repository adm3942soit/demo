package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.Product;

public interface ProductService {
    List<Product> findAll();
    Product getProductById(int pid);
    List<Product> getProductByCategory(String category);
    List<Product> load();
}
