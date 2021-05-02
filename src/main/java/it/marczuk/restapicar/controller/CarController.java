package it.marczuk.restapicar.controller;


import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.model.Engine;
import it.marczuk.restapicar.model.dto.CarDto;
import it.marczuk.restapicar.service.car_service.CarService;
import it.marczuk.restapicar.service.engine_service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final EngineService engineService;

    @GetMapping("/cars")
    public List<CarDto> getCars(@RequestParam(required = false) Integer page) {
        int pageTO = page != null && page > 0 ? page-1 : 0;
        return carService.getAllCars(pageTO);
    }

    @GetMapping("/cars/engines")
    public List<Car> getCarsWithEngines(@RequestParam(required = false) Integer page) {
        int pageTO = page != null && page > 0 ? page-1 : 0;
        return carService.getAllCarsWithEngines(pageTO);
    }

    @GetMapping("/cars/{id}")
    public CarDto getSingleCar(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/cars/engines/{id}")
    public Car getSingleCarWithEngine(@PathVariable Long id) {
//        throw new IllegalArgumentException("Note implemented yet!");
        return carService.getCarWithEngineById(id);
    }

    @GetMapping("/engines")
    public List<Engine> getEngines() {
        return engineService.getAllEngines();
    }

    @GetMapping("/engines/{id}")
    public Engine getSingleEngine(@PathVariable Long id) {
        return engineService.getEngineById(id);
    }
}
