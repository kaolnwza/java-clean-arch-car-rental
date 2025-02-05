package io.github.kaolnwza.java_clean_arch_car_rental.domain.car.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {
    private UUID id;
    private String name;
    private Integer speed;
    private Boolean isActive;
    protected String type;

    public CarDTO() {
        this.type = "normal";
    }

    public CarDTO(String name, Integer speed) {
        this.name = name;
        this.speed = speed;
        this.type = "normal";
    }
}
