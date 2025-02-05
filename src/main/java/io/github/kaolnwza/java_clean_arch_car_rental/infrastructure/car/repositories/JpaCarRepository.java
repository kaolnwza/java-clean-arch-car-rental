package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.car.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.CarsSchema;
import java.util.List;

public interface JpaCarRepository extends JpaRepository<CarsSchema, UUID> {
}
