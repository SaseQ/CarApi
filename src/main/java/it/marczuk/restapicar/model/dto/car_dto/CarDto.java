package it.marczuk.restapicar.model.dto.car_dto;

import it.marczuk.restapicar.model.Color;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CarDto {

    private Long id;
    private String mark;
    private String model;
    private Color color;
    private LocalDate productionDate;
}
