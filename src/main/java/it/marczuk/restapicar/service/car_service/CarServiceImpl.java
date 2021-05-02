package it.marczuk.restapicar.service.car_service;

import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.model.dto.CarDto;
import it.marczuk.restapicar.model.dto.CarDtoMapper;
import it.marczuk.restapicar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final int PAGE_SIZE = 20;

    private final CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars(int page) {
        return CarDtoMapper.mapToCarDtos(carRepository.findAllCars(PageRequest.of(page, PAGE_SIZE)));
    }

    @Override
    public List<Car> getAllCarsWithEngines(int page) {
        return carRepository.findAllCars(PageRequest.of(page, PAGE_SIZE));
    }

    @Override
    public CarDto getCarById(Long id) {
        return CarDtoMapper.mapToCarDtos(List.of(carRepository.findById(id).orElseThrow())).get(0);
    }

    @Override
    public Car getCarWithEngineById(Long id) {
        return carRepository.findById(id)
                .orElseThrow();
    }
}
