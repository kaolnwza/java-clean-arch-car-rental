package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema;

import java.util.UUID;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import io.github.kaolnwza.java_clean_arch_car_rental.utils.UUIDConverter;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class CarsSchema {
    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    private String name;
    private Integer speed;

    @Column(name = "is_active")
    private Boolean isActive;

    private String type;
}
