package com.manikandan.apicommon.response;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ApiErrorResponseTest {

    @Test
    void shouldSetFieldsCorrectly() {

        ApiErrorResponse response =
                new ApiErrorResponse();

        LocalDateTime now = LocalDateTime.now();

        response.setTimestamp(now);
        response.setStatus(404);
        response.setError("Not Found");
        response.setMessage("Product not found");

        assertEquals(now, response.getTimestamp());
        assertEquals(404, response.getStatus());
        assertEquals("Not Found", response.getError());
        assertEquals("Product not found",
                response.getMessage());
    }
}