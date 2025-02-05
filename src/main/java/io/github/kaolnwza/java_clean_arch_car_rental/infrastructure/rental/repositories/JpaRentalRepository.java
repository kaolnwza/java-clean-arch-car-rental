package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.rental.repositories;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema.RentalsSchema;

public interface JpaRentalRepository extends JpaRepository<RentalsSchema, UUID> {
    @Query(value = """
            SELECT COUNT(1)
            FROM rentals
            WHERE start_date <= :paramEndDate
            AND end_date >= :paramStartDate
            AND car_id = :paramCarId
            LIMIT 1
            """, nativeQuery = true)
    long getAvailableRentedCarByDateQuery(@Param("paramStartDate") Date startDate, @Param("paramEndDate") Date endDate,
            @Param("paramCarId") UUID carId);

    default boolean getAvailableRentedCarByDate(Date startDate, Date endDate, UUID carId) {
        return getAvailableRentedCarByDateQuery(startDate, endDate, carId) != 0;
    }
}
