package io.github.kaolnwza.java_clean_arch_car_rental.mapper;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.dto.CarDTO;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.CarsSchema;

public class CarMapper {
    public static CarDTO toDto(CarsSchema carSche) {
        CarDTO carDTO = new CarDTO();

        carDTO.setId(carSche.getId());
        carDTO.setName(carSche.getName());
        carDTO.setSpeed(carSche.getSpeed());
        carDTO.setType(carSche.getType());
        carDTO.setIsActive(carSche.getIsActive());

        return carDTO;
    }

    public static CarsSchema toSchema(CarDTO carDto) {
        CarsSchema carSchema = new CarsSchema();

        carSchema.setId(carDto.getId());
        carSchema.setName(carDto.getName());
        carSchema.setSpeed(carDto.getSpeed());
        carSchema.setType(carDto.getType());
        carSchema.setIsActive(carDto.getIsActive());

        return carSchema;
    }
}
