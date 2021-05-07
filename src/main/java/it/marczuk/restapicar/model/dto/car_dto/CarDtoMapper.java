package it.marczuk.restapicar.model.dto.car_dto;

import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.model.Engine;
import it.marczuk.restapicar.model.dto.engine_dto.EngineDto;
import it.marczuk.restapicar.model.dto.engine_dto.EngineDtoMapper;

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

    public static CarDto mapToCarDtos(Car car) {
        return mapToCarDto(car);
    }

    private static CarDto mapToCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .mark(car.getMark())
                .model(car.getModel())
                .color(car.getColor())
                .productionDate(car.getProductionDate())
                .engine(EngineDtoMapper.mapToEngineDtos(car.getEngine()))
                .build();
    }
}
