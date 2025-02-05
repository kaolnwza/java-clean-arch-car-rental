package io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.dto;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalApplicateDTO {
    @NonNull
    private UUID carId;

    @NonNull
    private UUID userId;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public RentalApplicateDTO(UUID carId, UUID userId, Date startDate, Date endDate) {
        this.carId = carId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
