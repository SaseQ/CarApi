package it.marczuk.restapicar.controller;


import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.model.Engine;
import it.marczuk.restapicar.model.dto.car_dto.CarDto;
import it.marczuk.restapicar.model.dto.engine_dto.EngineDto;
import it.marczuk.restapicar.service.car_service.CarService;
import it.marczuk.restapicar.service.engine_service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final EngineService engineService;

    @GetMapping("/cars")
    public List<Car> getCars(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        return carService.getAllCars(covertPage(page), setSortType(sort));
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PutMapping("/cars")
    public Car editCar(@RequestBody Car car) {
        return carService.editCar(car);
    }

    @PatchMapping("/cars")
    public Car editCarElement() {
        throw new IllegalArgumentException("Not implemented yet!");
    }

    @GetMapping("/cars/{id}")
    public Car getSingleCar(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/cars/engines")
    public List<CarDto> getCarsWithEngines(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        return carService.getAllCarsWithEngines(covertPage(page), setSortType(sort));
    }

    @GetMapping("/cars/engines/{id}")
    public CarDto getSingleCarWithEngine(@PathVariable Long id) {
        return carService.getCarWithEngineById(id);
    }

    @GetMapping("/engines")
    public List<EngineDto> getEngines(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        return engineService.getAllEngines(covertPage(page), setSortType(sort));
    }

    @PostMapping("/engines")
    public Engine addEngine(@RequestBody Engine engine) {
        return engineService.addEngine(engine);
    }

    @PutMapping("/engines")
    public Engine editEngine(@RequestBody Engine engine) {
        return engineService.editEngine(engine);
    }

    @PatchMapping("/engines")
    public Engine editEngineElement() {
        throw new IllegalArgumentException("Not implemented yet!");
    }

    @GetMapping("/engines/{id}")
    public EngineDto getSingleEngine(@PathVariable Long id) {
        return engineService.getEngineById(id);
    }

    @DeleteMapping("/engines/{id}")
    public void deleteEngine(@PathVariable Long id) {
        engineService.deleteEngine(id);
    }

    @GetMapping("/engines/cars")
    public List<Engine> getEnginesWithCars(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        return engineService.getAllEnginesWithCars(covertPage(page), setSortType(sort));
    }

    @GetMapping("/engines/cars/{id}")
    public Engine getSingleEngineWithCars(@PathVariable Long id) {
        return engineService.getEngineWithCarsById(id);
    }

    private int covertPage(Integer page) {
        return page != null && page > 0 ? page - 1 : 0;
    }

    private Sort.Direction setSortType(Sort.Direction sort) {
        return sort == null ? Sort.Direction.ASC : sort;
    }
}
