package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dao.Cart;
import com.example.demo.dao.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
@Slf4j
public class CartServiceImpl implements CartService {
    private TypeReference<List<Cart>> typeReference = new TypeReference<List<Cart>>() {
    };
    @Override
    public List<Cart> findAll() {
        return load();
    }

    @Override
    public Cart getCartByUserName(String userName) {
        List<Cart> all = load();
        for (final Cart cart : all) {
            if(cart.getUserName().equals(userName)){
                return cart;
            }
        }
        return null;
    }

    @Override
    public List<Product> getProductByCart(Long id){
        List<Cart> all = load();
        for (final Cart cart : all) {
            if(cart.getId().equals(id)){
                return cart.getProducts();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<Cart> load() {
        ObjectMapper mapper = new ObjectMapper();

        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/json/cart.json");
        List<Cart> carts = new ArrayList<>();
        try {
            carts = mapper.readValue(inputStream, typeReference);
            log.info("Carts Saved!");
        } catch (IOException e) {
            log.error("Unable to save carts: " + e.getMessage());
        }
        return carts;
    }
}
