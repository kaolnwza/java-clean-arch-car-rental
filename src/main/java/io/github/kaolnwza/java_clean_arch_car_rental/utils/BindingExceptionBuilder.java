package io.github.kaolnwza.java_clean_arch_car_rental.utils;

import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

public class BindingExceptionBuilder {
    public static String build(BindingResult v) {
        return v.getAllErrors().stream().map(e -> e.getDefaultMessage())
                .collect(Collectors.joining(", "));
    }
}
