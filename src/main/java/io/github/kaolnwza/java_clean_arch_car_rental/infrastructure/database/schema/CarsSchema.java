package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema;

import java.util.UUID;

import io.github.kaolnwza.java_clean_arch_car_rental.utils.UUIDConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class CarsSchema {
    @Id
    @GeneratedValue
    @Convert(converter = UUIDConverter.class)
    private UUID id;

    private String name;
    private Integer speed;

    @Column(name = "is_active")
    private Boolean isActive;

    private String type;

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
