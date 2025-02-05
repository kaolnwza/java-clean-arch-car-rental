package io.github.kaolnwza.java_clean_arch_car_rental.domain.car.exceptions;

import org.springframework.http.HttpStatus;

import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.response.Response;

public class CarException {
    private static final String PREFIX = "C";
    private static final String CODE_CAR_NOT_FOUND = "400";
    private static final String CODE_INTERNAL_SERVER_ERROR = "500";
    private static final String MSG_CAR_NOT_FOUND = "Car not found.";
    private static final String MSG_INTERNAL_SERVER_ERROR = "Internal server error.";

    public static <T> Response<T> CarExceptionNotFound() {
        return Response.NewError(HttpStatus.NOT_FOUND, CODE_CAR_NOT_FOUND, MSG_CAR_NOT_FOUND,
                new Exception(CODE_CAR_NOT_FOUND));
    }

    public static <T> Response<T> CarInternalServerError(Exception e) {
        return Response.NewInternalServerError(CODE_INTERNAL_SERVER_ERROR, MSG_INTERNAL_SERVER_ERROR, e);
    }

    protected static String addPrefix(String code) {
        return PREFIX + code;
    }

}
