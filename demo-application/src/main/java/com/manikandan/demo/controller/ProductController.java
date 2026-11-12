package com.manikandan.demo.controller;

import com.manikandan.demo.dto.ProductRequest;
import com.manikandan.demo.model.Product;
import com.manikandan.demo.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {

        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(
        @PathVariable("id") Long id) {

    return productService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(
            @Valid @RequestBody ProductRequest request) {

        return new Product(
                100L,
                request.getName());
    }
}