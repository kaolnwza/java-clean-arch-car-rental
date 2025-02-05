package io.github.kaolnwza.java_clean_arch_car_rental.usecases.rental;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.dto.RentalApplicateDTO;
import io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.exceptions.RentalException;
import io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.repositories.RentalReposotory;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.RentalsSchema;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.response.Response;
import io.github.kaolnwza.java_clean_arch_car_rental.usecases.car.GetCarUsecase;

public class RentalApplicateUsecase {
    private final RentalReposotory rentalRepo;
    private static final Logger logger = LoggerFactory.getLogger(RentalApplicateUsecase.class);

    public RentalApplicateUsecase(RentalReposotory rentalReposotory) {
        this.rentalRepo = rentalReposotory;
    }

    public <T> Response<T> execute(RentalApplicateDTO req) {
        try {
            if (rentalRepo.getAvailableRentedCarByDate(req.getStartDate(), req.getEndDate(), req.getCarId())) {
                return RentalException.RentalExceptionCarIsNotAvailable();
            }

            rentalRepo.save(req);

            return Response.New(null);

        } catch (Exception e) {
            logger.error("app err " + e.toString());
            return RentalException.RentalExceptionInternalServerError(e);
        }
    }
}
