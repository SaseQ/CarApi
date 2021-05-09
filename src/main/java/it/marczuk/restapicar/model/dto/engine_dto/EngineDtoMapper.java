package it.marczuk.restapicar.model.dto.engine_dto;

import it.marczuk.restapicar.model.Engine;

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

    public static EngineDto mapToEngineDtos(Engine engine) {
        return mapToEngineDto(engine);
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
