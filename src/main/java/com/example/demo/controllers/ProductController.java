package com.example.demo.controllers;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.Product;
import com.example.demo.facades.ProductServiceFacade;
import com.example.demo.facades.ProductServiceFacadeImpl;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/rest/products")
public class ProductController {

    private ProductServiceFacade productServiceFacade;

    @Autowired
    private ProductController(ProductService productService) {
        productServiceFacade= new ProductServiceFacadeImpl(productService);
    }
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts() {

        List<Product> products = productServiceFacade.findAll();

        return products;
    }

    @GetMapping(value = "/category/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Product> filterProducts(@PathVariable("category") String productCategory ) {
        Set<Product> common = new HashSet<>(productServiceFacade.getProductByCategory(productCategory));
        return common;
    }
}
