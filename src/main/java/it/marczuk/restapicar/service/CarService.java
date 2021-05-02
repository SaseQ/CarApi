package it.marczuk.restapicar.service;

import it.marczuk.restapicar.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> findAllPosts();

    Car findCarById(Long id);
}
