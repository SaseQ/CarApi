package it.marczuk.restapicar.service.engine_service;

import it.marczuk.restapicar.model.Engine;

import java.util.List;

public interface EngineService {

    List<Engine> getAllEngines();

    Engine getEngineById(Long id);
}
