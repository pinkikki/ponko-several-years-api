package jp.pinkikki.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * エラーハンドリングを作成したが、{@link ResponseEntityExceptionHandler}が存在することを知ったため、
 * {@RestControllerAdvice}をコメントアウト
 */
//@RestControllerAdvice
public class OriginalApiExceptionHandler {

    private final ErrorResponseBuilder errorResponseBuilder;

    public OriginalApiExceptionHandler(ErrorResponseBuilder errorResponseBuilder) {
        this.errorResponseBuilder = errorResponseBuilder;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException exception) {
        return errorResponseBuilder
                .message(exception.getMessage())
                .bindingResult(exception.getBindingResult())
                .build();
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(BindException exception) {
        return errorResponseBuilder
                .message(exception.getMessage())
                .bindingResult(exception.getBindingResult())
                .build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(HttpMessageNotReadableException exception) {
        return errorResponseBuilder
                .message(exception.getMessage())
                .build();
    }

}
