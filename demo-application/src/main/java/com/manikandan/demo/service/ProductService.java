package com.manikandan.demo.service;

import com.manikandan.apicommon.exception.ResourceNotFoundException;
import com.manikandan.demo.model.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public Product getProduct(Long id) {

        if (id != 1L) {
            throw new ResourceNotFoundException(
                    "Product not found with id: " + id);
        }

        return new Product(1L, "Laptop");
    }

    public List<Product> getProducts() {

        return List.of(
                new Product(1L, "Laptop"),
                new Product(2L, "Mobile"));
    }
}