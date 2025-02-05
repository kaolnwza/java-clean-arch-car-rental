package io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.car.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.dto.CarDTO;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.response.Response;
import io.github.kaolnwza.java_clean_arch_car_rental.usecases.car.GetCarUsecase;
import io.github.kaolnwza.java_clean_arch_car_rental.usecases.car.ListCarUsecase;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final GetCarUsecase getCarUc;
    private final ListCarUsecase listCarUc;

    public CarController(GetCarUsecase getCarUc, ListCarUsecase listCarUc) {
        this.getCarUc = getCarUc;
        this.listCarUc = listCarUc;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<CarDTO>> GetCarController(@PathVariable UUID id) {
        Response<CarDTO> resp = getCarUc.execute(id);
        if (resp.isErr()) {
            return ResponseEntity.status(resp.getStatus()).body(resp);
        }

        return ResponseEntity.ok(resp);
    }

    @GetMapping("")
    public ResponseEntity<Response<List<CarDTO>>> ListCarController() {
        Response<List<CarDTO>> resp = listCarUc.execute();
        if (resp.isErr()) {
            return ResponseEntity.status(resp.getStatus()).body(resp);
        }

        return ResponseEntity.ok(resp);
    }

}
// @RestController
// public class GetAdminController {

// private final GetAdminUseCase getAdminUseCase;

// public GetAdminController(GetAdminUseCase getAdminUseCase) {
// this.getAdminUseCase = getAdminUseCase;
// }

// @GetMapping("/admins/{id}")
// @ResponseStatus(HttpStatus.CREATED)
// public AdminPublicData getAdmin(@PathVariable Long id) throws
// AdminNotFoundException {
// Admin admin = getAdminUseCase.execute(id);

// return new AdminPublicData(admin);
// }

// }
