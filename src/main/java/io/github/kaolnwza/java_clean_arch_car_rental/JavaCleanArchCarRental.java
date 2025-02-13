package io.github.kaolnwza.java_clean_arch_car_rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.kaolnwza.java_clean_arch_car_rental.domain.car.repositories.CarRepository;
import io.github.kaolnwza.java_clean_arch_car_rental.domain.rental.repositories.RentalReposotory;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.car.repositories.CarRepositoryImpl;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.car.repositories.JpaCarRepository;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.rental.repositories.JpaRentalRepository;
import io.github.kaolnwza.java_clean_arch_car_rental.infrastructure.rental.repositories.RentalRepositoryImpl;
import io.github.kaolnwza.java_clean_arch_car_rental.usecases.car.GetCarUsecase;
import io.github.kaolnwza.java_clean_arch_car_rental.usecases.car.ListCarUsecase;
import io.github.kaolnwza.java_clean_arch_car_rental.usecases.rental.RentalApplicateUsecase;

@SpringBootApplication
public class JavaCleanArchCarRental {

	public static void main(String[] args) {

		SpringApplication.run(JavaCleanArchCarRental.class, args);
	}

	@Bean
	public GetCarUsecase getCarUsecase(JpaCarRepository jpaCarRepo) {
		CarRepository carRepo = new CarRepositoryImpl(jpaCarRepo);
		return new GetCarUsecase(carRepo);
	}

	@Bean
	public ListCarUsecase listCarUsecase(JpaCarRepository jpaCarRepo) {
		CarRepository carRepo = new CarRepositoryImpl(jpaCarRepo);
		return new ListCarUsecase(carRepo);
	}

	// @Bean
	// public RentalApplicateUsecase rentalApplicateUsecase(JpaRentalRepository
	// jpaRentalRepository) {
	// RentalReposotory rentalReposotory = new
	// RentalRepositoryImpl(jpaRentalRepository);
	// return new RentalApplicateUsecase(rentalReposotory);
	// }

	// @Bean
	// public GetCarUsecases getCarUsecases(CarReposotory carRepo) {
	// CarRepositoryImpl carRepoImpl = new CarRepositoryImpl()
	// }

}
