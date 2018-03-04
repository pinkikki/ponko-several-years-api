package jp.pinkikki.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final ErrorResponseBuilder errorResponseBuilder;

    public ApiExceptionHandler(ErrorResponseBuilder errorResponseBuilder) {
        this.errorResponseBuilder = errorResponseBuilder;
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers, HttpStatus status, WebRequest request) {

        return super.handleExceptionInternal(ex,
                errorResponseBuilder
                        .message(ex.getMessage())
                        .build(),
                headers,
                status,
                request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex,
                errorResponseBuilder
                        .message(ex.getMessage())
                        .bindingResult(ex.getBindingResult())
                        .build(),
                headers,
                status,
                request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
                                                         HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex,
                errorResponseBuilder
                        .message(ex.getMessage())
                        .bindingResult(ex.getBindingResult())
                        .build(),
                headers,
                status,
                request);
    }
}
