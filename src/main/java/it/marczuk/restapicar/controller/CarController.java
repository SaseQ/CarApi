package it.marczuk.restapicar.controller;


import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/posts")
    public List<Car> getCars() {
        return carService.findAllPosts();
    }

    @GetMapping("/post/{id}")
    public Car getSingleCar(@PathVariable Long id) {
//        throw new IllegalArgumentException("Note implemented yet!");
        return carService.findCarById(id);
    }
}
