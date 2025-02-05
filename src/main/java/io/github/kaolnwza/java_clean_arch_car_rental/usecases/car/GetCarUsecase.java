package io.github.kaolnwza.java_clean_arch_car_rental.usecases.car;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.dto.CarDTO;
import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.exceptions.CarException;
import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.repositories.CarRepository;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.CarsSchema;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.response.Response;
import io.github.kaolnwza.java_clean_arch_car_rental.mapper.CarMapper;

public class GetCarUsecase {
    private final CarRepository carRepo;
    private static final Logger logger = LoggerFactory.getLogger(GetCarUsecase.class);

    public GetCarUsecase(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    public Response<CarDTO> execute(UUID id) {
        System.out.println("dddd " + id);
        try {

            Optional<CarsSchema> carSche = carRepo.get(id);
            System.out.println("ccccccc" + carSche);
            if (carSche.isEmpty()) {
                logger.error("not found");
                return CarException.CarExceptionNotFound();
            }

            CarDTO carDto = CarMapper.toDto(carSche.get());
            return Response.New(carDto);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return CarException.CarInternalServerError(e);
        }
    }
}
