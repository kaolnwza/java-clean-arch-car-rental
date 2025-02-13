package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.rental.repositories;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.dto.RentalApplicateDTO;
import io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.repositories.RentalReposotory;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.RentalsSchema;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RentalRepositoryImpl implements RentalReposotory {
    private final JpaRentalRepository jpaRentalRepo;

    @Override
    public RentalsSchema save(RentalApplicateDTO app) {
        RentalsSchema schema = new RentalsSchema(app.getCarId(), app.getUserId(), app.getStartDate(), app.getEndDate());
        return this.jpaRentalRepo.save(schema);
    }

    @Override
    public boolean getAvailableRentedCarByDate(Date startDate, Date endDate, UUID carId) {
        return this.jpaRentalRepo.getAvailableRentedCarByDate(startDate, endDate, carId);
    }

}
