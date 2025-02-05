package io.github.kaolnwza.java_clean_arch_car_rental.domain.car.dto;

import java.util.UUID;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
