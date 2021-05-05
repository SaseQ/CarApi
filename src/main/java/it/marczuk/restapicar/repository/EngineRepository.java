package it.marczuk.restapicar.repository;

import it.marczuk.restapicar.model.Engine;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EngineRepository extends JpaRepository<Engine, Long> {

    @Query("select e from engines e")
    List<Engine> findAllEngines(Pageable page);
}
