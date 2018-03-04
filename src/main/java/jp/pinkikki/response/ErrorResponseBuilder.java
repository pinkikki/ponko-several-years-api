package jp.pinkikki.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class ErrorResponseBuilder {
    private List<Error> errors;
    private String code;
    private String message;
    private final MessageSource messageSource;

    @Autowired
    ErrorResponseBuilder(MessageSource messageSource) {
        errors = new ArrayList<>();
        this.messageSource = messageSource;
    }

    ErrorResponseBuilder code(String code) {
        this.code = code;
        return this;
    }

    ErrorResponseBuilder message(String message) {
        this.message = message;
        return this;
    }

    ErrorResponseBuilder error(Error error) {
        errors.add(error);
        return this;
    }

    ErrorResponseBuilder error(String errorCode, String field, String detail) {
        errors.add(new Error(errorCode, field, detail));
        return this;
    }

    ErrorResponseBuilder bindingResult(BindingResult bindingResult) {
        errors = bindingResult
                .getFieldErrors()
                .stream()
                .map(f -> new Error(
                        f.getCode(),
                        f.getField(),
                        messageSource.getMessage(f, LocaleContextHolder.getLocale())))
                .collect(Collectors.toList());
        return this;
    }

    ErrorResponse build() {
        return new ErrorResponse(code, message, errors);
    }
}
