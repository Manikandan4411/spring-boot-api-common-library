package com.manikandan.apicommon.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundExceptionTest {

    @Test
    void shouldStoreMessage() {

        String message = "Product not found";

        ResourceNotFoundException exception =
                new ResourceNotFoundException(message);

        assertEquals(message, exception.getMessage());
    }
}