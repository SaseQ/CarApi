package it.marczuk.restapicar.model.dto.engine_dto;

import it.marczuk.restapicar.model.Car;
import it.marczuk.restapicar.model.Engine;
import it.marczuk.restapicar.model.dto.car_dto.CarDto;
import it.marczuk.restapicar.model.dto.car_dto.CarDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EngineDtoMapper {

    private EngineDtoMapper() {
    }

    public static List<EngineDto> mapToEngineDtos(List<Engine> allEngines) {
        return allEngines.stream()
                .map(EngineDtoMapper::mapToEngineDto)
                .collect(Collectors.toList());
    }

    private static EngineDto mapToEngineDto(Engine engine) {
        return EngineDto.builder()
                .id(engine.getId())
                .model(engine.getModel())
                .engineType(engine.getEngineType())
                .productionDate(engine.getProductionDate())
                .build();
    }
}
