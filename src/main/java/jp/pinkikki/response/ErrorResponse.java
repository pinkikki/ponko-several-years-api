package jp.pinkikki.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class ErrorResponse implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String code;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Error> errors;

    ErrorResponse(String code, String message, List<Error> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }
}
