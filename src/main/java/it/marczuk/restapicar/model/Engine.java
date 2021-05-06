package it.marczuk.restapicar.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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
    @OneToMany(mappedBy = "engine", cascade = CascadeType.REMOVE)
    private Set<Car> car;
}
