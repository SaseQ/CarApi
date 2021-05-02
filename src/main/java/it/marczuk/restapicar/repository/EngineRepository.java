package it.marczuk.restapicar.repository;

import it.marczuk.restapicar.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
