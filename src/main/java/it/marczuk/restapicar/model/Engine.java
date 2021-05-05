package it.marczuk.restapicar.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "engines")
@Getter
@Setter
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private EngineType engineType;
    private LocalDate productionDate;
}
