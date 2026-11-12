package com.manikandan.apicommon.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ForbiddenExceptionTest {

     @Test
    void shouldStoreMessage() {

        String message = "Forbidden error";

        ForbiddenException exception =
                new ForbiddenException(message);

        assertEquals(message, exception.getMessage());
    }
}


