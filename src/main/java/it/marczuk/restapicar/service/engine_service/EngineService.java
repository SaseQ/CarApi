package it.marczuk.restapicar.service.engine_service;

import it.marczuk.restapicar.model.Engine;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EngineService {

    List<Engine> getAllEngines(int page, Sort.Direction sort);

    Engine getEngineById(Long id);

    Engine addEngine(Engine engine);

    Engine editEngine(Engine engine);

}
