package it.marczuk.restapicar.service.car_service;

import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.model.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDto> getAllCars(int page);

    List<Car> getAllCarsWithEngines(int page);

    CarDto getCarById(Long id);

    Car getCarWithEngineById(Long id);
}
