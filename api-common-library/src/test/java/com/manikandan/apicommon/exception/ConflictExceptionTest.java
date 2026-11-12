package com.manikandan.apicommon.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConflictExceptionTest {
    @Test
    void shouldStoreMessage() {

        String message = "conflict error";

        ConflictException exception =
                new ConflictException(message);

        assertEquals(message, exception.getMessage());
    }
}


