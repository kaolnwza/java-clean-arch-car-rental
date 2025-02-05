package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    @JsonIgnore
    private HttpStatus status;
    private String code;
    private String message;
    private T data;

    @JsonIgnore
    private Exception err;

    protected static final String CODE_BAD_REQUEST = "400";

    public Response(HttpStatus status, String code, String message, T data, Exception err) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.err = err;
    }

    public static <T> Response<T> NewError(HttpStatus status, String code, String message, Exception err) {
        return new Response<>(status, code, message, null, err);
    }

    public static <T> Response<T> New(T data) {
        return new Response<T>(null, "0", "success", data, null);
    }

    public static <T> Response<T> NewInternalServerError(String code, String msg, Exception err) {
        if (msg.isEmpty() || msg == null) {
            msg = "Internal server error.";
        }

        return new Response<T>(HttpStatus.INTERNAL_SERVER_ERROR, code, msg, null, err);
    }

    public static <T> Response<T> NewBadRequestError(String msg, Exception err) {
        if (msg.isEmpty() || msg == null) {
            msg = "Bad request.";
        }

        return new Response<T>(HttpStatus.BAD_REQUEST, CODE_BAD_REQUEST, msg, null, err);
    }

    public boolean isErr() {
        return err != null;
    }
}
