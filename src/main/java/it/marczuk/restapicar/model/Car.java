package it.marczuk.restapicar.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "cars")
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String mark;
    private String model;
    private Color color;
    private LocalDate productionDate;
    @OneToOne
    private Engine engine;
}
