package io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.exceptions;

import org.springframework.http.HttpStatus;

import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.response.Response;

public class RentalException {
    private static final String PREFIX = "R";
    private static final String CODE_CAR_IS_NOT_AVAILABLE = "402";
    private static final String MSG_CAR_IS_NOT_AVAILABLE = "Car is not available for renting.";

    public static <T> Response<T> RentalExceptionCarIsNotAvailable() {
        return Response.NewError(HttpStatus.NOT_FOUND, CODE_CAR_IS_NOT_AVAILABLE, MSG_CAR_IS_NOT_AVAILABLE,
                new Exception());
    }

    public static <T> Response<T> RentalExceptionInternalServerError(Exception e) {
        return Response.NewInternalServerError("500", "Internal server error.", e);
    }

    protected static String addPrefix(String code) {
        return PREFIX + code;
    }

}
