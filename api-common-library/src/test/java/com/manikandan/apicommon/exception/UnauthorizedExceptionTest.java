package com.manikandan.apicommon.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnauthorizedExceptionTest {
    @Test
    void shouldStoreMessage() {

        String message = "Unauthorized error";

        UnauthorizedException exception =
                new UnauthorizedException(message);

        assertEquals(message, exception.getMessage());
    }
}

