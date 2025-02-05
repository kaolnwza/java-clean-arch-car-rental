package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.database.schema;

import java.util.Date;
import java.util.UUID;

import io.github.kaolnwza.java_clean_arch_car_rental.utils.UUIDConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rentals")
public class RentalsSchema {
    @Id
    @GeneratedValue

    private UUID id;
    @Column(name = "car_id")
    private UUID carId;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    public RentalsSchema(UUID carId, UUID userId, Date startDate, Date endDate) {
        this.carId = carId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
