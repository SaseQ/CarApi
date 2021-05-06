package it.marczuk.restapicar.service.car_service;

import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.model.dto.car_dto.CarDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CarService {

    List<CarDto> getAllCars(int page, Sort.Direction sort);

    List<Car> getAllCarsWithEngines(int page, Sort.Direction sort);

    CarDto getCarById(Long id);

    Car getCarWithEngineById(Long id);

    Car addCar(Car car);

    Car editCar(Car car);

    void deleteCar(Long id);

}
