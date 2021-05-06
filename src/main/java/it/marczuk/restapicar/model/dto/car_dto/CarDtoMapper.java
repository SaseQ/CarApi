package it.marczuk.restapicar.model.dto.car_dto;

import it.marczuk.restapicar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarDtoMapper {

    private CarDtoMapper() {
    }

    public static List<CarDto> mapToCarDtos(List<Car> allCars) {
        return allCars.stream()
                .map(CarDtoMapper::mapToCarDto)
                .collect(Collectors.toList());
    }

    private static CarDto mapToCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .mark(car.getMark())
                .model(car.getModel())
                .color(car.getColor())
                .productionDate(car.getProductionDate())
                .build();
    }
}
