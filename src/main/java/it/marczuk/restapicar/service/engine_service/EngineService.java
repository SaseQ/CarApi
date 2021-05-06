package it.marczuk.restapicar.service.engine_service;

import it.marczuk.restapicar.model.Engine;
import it.marczuk.restapicar.model.dto.engine_dto.EngineDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EngineService {

    List<EngineDto> getAllEngines(int page, Sort.Direction sort);

    List<Engine> getAllEnginesWithCars(int page, Sort.Direction sort);

    EngineDto getEngineById(Long id);

    Engine getEngineWithCarsById(Long id);

    Engine addEngine(Engine engine);

    Engine editEngine(Engine engine);

    void deleteEngine(Long id);

}
