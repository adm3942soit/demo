package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.Cart;
import com.example.demo.dao.Product;

public interface CartService {
    List<Cart> findAll();
    Cart getCartByUserName(String userName);
    List<Product> getProductByCart(Long id);
    List<Cart> load();
}
