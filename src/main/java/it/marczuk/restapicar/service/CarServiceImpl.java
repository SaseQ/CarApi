package it.marczuk.restapicar.service;

import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<Car> findAllPosts() {
        return carRepository.findAll();
    }

    @Override
    public Car findCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow();
    }
}
