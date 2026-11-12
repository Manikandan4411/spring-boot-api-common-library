package com.manikandan.apicommon.handler;

import com.manikandan.apicommon.exception.BadRequestException;
import com.manikandan.apicommon.exception.ConflictException;
import com.manikandan.apicommon.exception.ForbiddenException;
import com.manikandan.apicommon.exception.ResourceNotFoundException;
import com.manikandan.apicommon.exception.UnauthorizedException;
import com.manikandan.apicommon.response.ApiErrorResponse;

import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex) {

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(
            BadRequestException ex) {

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiErrorResponse> handleUnauthorized(
            UnauthorizedException ex) {

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setError(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        response.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApiErrorResponse> handleForbidden(
            ForbiddenException ex) {

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setError(HttpStatus.FORBIDDEN.getReasonPhrase());
        response.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(response);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiErrorResponse> handleConflict(
            ConflictException ex) {

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.CONFLICT.value());
        response.setError(HttpStatus.CONFLICT.getReasonPhrase());
        response.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> validationErrors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        validationErrors.put(
                                error.getField(),
                                error.getDefaultMessage()));

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError("Validation Failed");
        response.setMessage("Request validation failed");
        response.setValidationErrors(validationErrors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex) {

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setMessage(ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiErrorResponse> handleUnreadableMessage(
            HttpMessageNotReadableException ex) {

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setMessage("Malformed JSON request.");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiErrorResponse> handleMissingParameter(
            MissingServletRequestParameterException ex) {

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setMessage(ex.getParameterName() + " parameter is required");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(
            Exception ex) {

        ex.printStackTrace();

        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setMessage("An unexpected error occurred.");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}