package it.marczuk.restapicar.service.engine_service;

import it.marczuk.restapicar.model.Engine;
import it.marczuk.restapicar.repository.EngineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {

    private final EngineRepository engineRepository;

    @Override
    public List<Engine> getAllEngines() {
        return engineRepository.findAll();
    }

    @Override
    public Engine getEngineById(Long id) {
        return engineRepository.findById(id)
                .orElseThrow();
    }
}
