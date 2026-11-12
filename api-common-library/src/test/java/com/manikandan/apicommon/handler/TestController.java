package com.manikandan.apicommon.handler;

import com.manikandan.apicommon.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/not-found")
    public String notFound() {

        throw new ResourceNotFoundException("Product not found");
    }
}