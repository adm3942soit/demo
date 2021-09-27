package com.example.demo.facades;

import java.util.List;

import com.example.demo.dao.Product;
import com.example.demo.service.ProductService;

public class ProductServiceFacadeImpl implements ProductServiceFacade {

    private final ProductService productService;

    public ProductServiceFacadeImpl(final ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public Product getProductById(final int pid) {
        return productService.getProductById(pid);
    }

    @Override
    public List<Product> getProductByCategory(final String category) {
        return productService.getProductByCategory(category);
    }
}
