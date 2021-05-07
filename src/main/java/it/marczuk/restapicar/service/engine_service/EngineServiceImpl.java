package it.marczuk.restapicar.service.engine_service;

import it.marczuk.restapicar.model.Engine;
import it.marczuk.restapicar.model.dto.engine_dto.EngineDto;
import it.marczuk.restapicar.model.dto.engine_dto.EngineDtoMapper;
import it.marczuk.restapicar.repository.EngineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {

    private final int PAGE_SIZE = 20;

    private final EngineRepository engineRepository;

    @Override
    public List<EngineDto> getAllEngines(int page, Sort.Direction sort) {
        return EngineDtoMapper.mapToEngineDtos(engineRepository.findAllEngines(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id"))));
    }

    @Override
    public List<Engine> getAllEnginesWithCars(int page, Sort.Direction sort) {
        return engineRepository.findAllEngines(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    @Override
    public EngineDto getEngineById(Long id) {
        return EngineDtoMapper.mapToEngineDtos(engineRepository.findById(id).orElseThrow());
    }

    @Override
    public Engine getEngineWithCarsById(Long id) {
        return engineRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Engine addEngine(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    @Transactional
    public Engine editEngine(Engine engine) {
        Engine engineEdited = engineRepository.findById(engine.getId()).orElseThrow();
        engineEdited.setModel(engine.getModel());
        engineEdited.setEngineType(engine.getEngineType());
        engineEdited.setProductionDate(engine.getProductionDate());
        return engineEdited;
    }

    @Override
    public void deleteEngine(Long id) {
        engineRepository.deleteById(id);
    }
}
