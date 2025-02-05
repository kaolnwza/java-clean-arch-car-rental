// package io.github.kaolnwza.java_clean_arch_car_rental.usecases.rental;

// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;

// import
// io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.dto.RentalDTO;
// import
// io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.usecases.RentalUsecase;
// import
// io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.response.Response;

// public class RentalUsecaseImpl implements RentalUsecase {
// private final GetCarUsecases getCarUsecase;

// @Autowired
// public CarUsecaseImpl(GetCarUsecases getCarUsecase) {
// this.getCarUsecase = getCarUsecase;
// }

// public Response<CarDTO> getCar(UUID id) {
// return getCarUsecase.execute(id);
// }
// }
