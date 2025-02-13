package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.rental.controllers;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.dto.RentalApplicateDTO;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.response.Response;
import io.github.kaolnwza.java_clean_arch_car_rental.usecases.rental.RentalApplicateUsecase;
import io.github.kaolnwza.java_clean_arch_car_rental.utils.BindingExceptionBuilder;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {
    private final RentalApplicateUsecase rentalApplicateUsecase;

    @PostMapping("")
    public ResponseEntity<Response<?>> RentalApplicateController(
            @Validated @RequestBody RentalApplicateDTO req,
            BindingResult bindRes) {

        if (bindRes.hasErrors()) {
            String err = BindingExceptionBuilder.build(bindRes);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.NewBadRequestError(err, null));
        }

        Response<?> resp = rentalApplicateUsecase.execute(req);
        if (resp.isErr()) {
            return ResponseEntity.status(resp.getStatus()).body(resp);
        }

        return ResponseEntity.ok(resp);
    }
}

// @RestController
// @RequestMapping("/cars")
// public class CarController {
// private final GetCarUsecase getCarUc;

// public CarController(GetCarUsecase getCarUc) {
// this.getCarUc = getCarUc;
// }

// @GetMapping("/{id}")
// public ResponseEntity<Response<CarDTO>> GetCarController(@PathVariable UUID
// id) {
// Response<CarDTO> resp = getCarUc.execute(id);
// if (resp.getErr() != null) {
// return ResponseEntity.status(resp.getStatus()).body(resp);
// }

// return ResponseEntity.ok(resp);
// }

// }