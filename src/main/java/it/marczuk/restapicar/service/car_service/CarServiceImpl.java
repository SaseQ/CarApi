package it.marczuk.restapicar.service.car_service;

import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.model.dto.car_dto.CarDto;
import it.marczuk.restapicar.model.dto.car_dto.CarDtoMapper;
import it.marczuk.restapicar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final int PAGE_SIZE = 20;

    private final CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars(int page, Sort.Direction sort) {
        return CarDtoMapper.mapToCarDtos(carRepository.findAllCars(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id"))));
    }

    @Override
    public List<Car> getAllCarsWithEngines(int page, Sort.Direction sort) {
        return carRepository.findAllCars(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
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

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public Car editCar(Car car) {
        Car carEdited = carRepository.findById(car.getId()).orElseThrow();
        carEdited.setMark(car.getMark());
        carEdited.setModel(car.getModel());
        carEdited.setColor(car.getColor());
        carEdited.setProductionDate(car.getProductionDate());
        return carEdited;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
