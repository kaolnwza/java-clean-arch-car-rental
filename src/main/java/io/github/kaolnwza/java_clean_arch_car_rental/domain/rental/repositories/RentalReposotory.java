package io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.repositories;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.dto.RentalApplicateDTO;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.RentalsSchema;

public interface RentalReposotory {
    RentalsSchema save(RentalApplicateDTO app);

    boolean getAvailableRentedCarByDate(Date startDate, Date endDate, UUID carId);
}
