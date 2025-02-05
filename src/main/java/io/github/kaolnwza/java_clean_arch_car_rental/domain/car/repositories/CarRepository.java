package io.github.kaolnwza.java_clean_arch_car_rental.domain.car.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.dto.CarDTO;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.CarsSchema;

public interface CarRepository {
    Optional<CarsSchema> get(UUID id);

    List<CarsSchema> list();
}
