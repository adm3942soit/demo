package com.example.demo.facades;

import java.util.List;

import com.example.demo.dao.Cart;
import com.example.demo.dao.Product;

public interface CartServiceFacade {
    List<Cart> findAll();
    Cart getCartByUserName(String userName);
    List<Product> getProductByCart(Long id);
}
