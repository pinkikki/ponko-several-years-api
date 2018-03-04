package jp.pinkikki.response;

import lombok.Getter;

@Getter
public class Error {
    private String code;
    private String field;
    private String detail;

    Error(String code, String field, String detail) {
        this.code = code;
        this.field = field;
        this.detail = detail;
    }
}
