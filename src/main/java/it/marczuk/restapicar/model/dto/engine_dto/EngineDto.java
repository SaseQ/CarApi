package it.marczuk.restapicar.model.dto.engine_dto;

import it.marczuk.restapicar.model.EngineType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class EngineDto {

    private Long id;
    private String model;
    private EngineType engineType;
    private LocalDate productionDate;
}
