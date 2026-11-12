package com.manikandan.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 50)
    private String name;

    public ProductRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}