package com.rq.loyalty.exception.handler;

import com.rq.loyalty.exception.DataAlreadyRegisteredException;
import com.rq.loyalty.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String INVALIDATION_MESSAGE = "One or more fields are invalid! " +
            "Fill in correctly and try again.";

    private static final String GENERIC_ERROR_MESSAGE = "Unexpected condition while processing the request. " +
            "Try again, and if the problem persists, contact your administrator.";

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    private ResponseEntity<Object> handleValidationException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ApiError.Field> fields = getFieldsWithError(ex);

        var apiError = ApiError.builder()
                .status(status.value())
                .title(INVALIDATION_MESSAGE)
                .detail("Fill in the data that are mandatory, and respect the limit/maximum value of the characters.")
                .fields(fields)
                .build();

        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(DataAlreadyRegisteredException.class)
    protected ResponseEntity<Object> handleDataAlreadyRegistered(DataAlreadyRegisteredException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        var apiError = ApiError.builder()
                .status(status.value())
                .title("Bad Request")
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;

        var apiError = ApiError.builder()
                .status(status.value())
                .title("Not Found")
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleUncaughtException(Exception ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError.builder()
                .status(status.value())
                .title("Internal Server Error")
                .detail(GENERIC_ERROR_MESSAGE)
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRunTime(RuntimeException ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError.builder()
                .status(status.value())
                .title("Internal Server Error")
                .detail(GENERIC_ERROR_MESSAGE)
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    private List<ApiError.Field> getFieldsWithError(Exception ex) {
        return ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> ApiError.Field.builder()
                        .name(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build())
                .toList();
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var apiError = ApiError.builder()
                .status(status.value())
                .title(status.getReasonPhrase())
                .build();

        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

}
