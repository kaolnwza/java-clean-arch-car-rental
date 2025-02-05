package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.car.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.repositories.CarRepository;

import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.CarsSchema;

@Repository
public class CarRepositoryImpl implements CarRepository {
    private final JpaCarRepository jpaCarRepo;

    public CarRepositoryImpl(JpaCarRepository jpaCarRepo) {
        this.jpaCarRepo = jpaCarRepo;
    }

    @Override
    public Optional<CarsSchema> get(UUID id) {
        System.out.println("id = " + id);
        return jpaCarRepo.findById(id);
    }

    @Override
    public List<CarsSchema> list() {
        return jpaCarRepo.findAll();
    }
}
