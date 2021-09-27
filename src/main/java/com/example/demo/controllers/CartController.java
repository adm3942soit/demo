package com.example.demo.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Cart;
import com.example.demo.dao.Product;
import com.example.demo.facades.CartServiceFacade;
import com.example.demo.facades.CartServiceFacadeImpl;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/rest/carts")
public class CartController {

    private CartServiceFacade cartServiceFacade;

    @Autowired
    private CartController(CartService cartService) {
        cartServiceFacade = new CartServiceFacadeImpl(cartService);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cart> getProducts() {
        return cartServiceFacade.findAll();
    }

    @GetMapping(value = "/user/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductsInCartByUserName(@PathVariable("userName") String userName ) {
        return cartServiceFacade.getCartByUserName(userName).getProducts();
    }


}
