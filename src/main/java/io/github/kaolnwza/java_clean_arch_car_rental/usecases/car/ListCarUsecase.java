package io.github.kaolnwza.java_clean_arch_car_rental.usecases.car;

import java.util.ArrayList;
import java.util.List;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.dto.CarDTO;
import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.exceptions.CarException;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.CarsSchema;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.response.Response;
import io.github.kaolnwza.java_clean_arch_car_rental.mapper.CarMapper;
import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.repositories.CarRepository;

public class ListCarUsecase {
    private final CarRepository carRepo;

    public ListCarUsecase(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    public Response<List<CarDTO>> execute() {
        try {
            List<CarsSchema> carSchema = carRepo.list();
            List<CarDTO> carDto = new ArrayList<>();
            for (var each : carSchema) {
                carDto.add(CarMapper.toDto(each));
            }

            return Response.New(carDto);

        } catch (Exception e) {
            return CarException.CarInternalServerError(e);
        }
    }
}
