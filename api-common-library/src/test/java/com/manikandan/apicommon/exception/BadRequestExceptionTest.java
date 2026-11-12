package com.manikandan.apicommon.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BadRequestExceptionTest {
    
    @Test
    void shouldStoreMessage() {

        String message = "Bad request not found";

        BadRequestException exception =
                new BadRequestException(message);

        assertEquals(message, exception.getMessage());
    }
}
