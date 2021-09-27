package com.example.demo.facades;

import java.util.List;

import com.example.demo.dao.Cart;
import com.example.demo.dao.Product;
import com.example.demo.service.CartService;

public class CartServiceFacadeImpl implements CartServiceFacade {
    private final CartService cartService;

    public CartServiceFacadeImpl(final CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public List<Cart> findAll() {
        return cartService.findAll();
    }

    @Override
    public Cart getCartByUserName(final String userName) {
        return cartService.getCartByUserName(userName);
    }

    @Override
    public List<Product> getProductByCart(final Long id) {
        return cartService.getProductByCart(id);
    }
}
