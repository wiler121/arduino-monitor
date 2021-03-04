package mf.arduino.arduinomonitor.services.map;

import mf.arduino.arduinomonitor.model.Lights;
import mf.arduino.arduinomonitor.repositories.LightsRepository;
import mf.arduino.arduinomonitor.services.LightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LightsMapService extends AbstractMapService<Lights, Long> implements LightsService {

    @Autowired
    LightsRepository lightsRepository;

    @Override
    public Page<Lights> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.lightsRepository.findAll(pageable);
    }

    @Override
    public List<Lights> listAll() {
        return lightsRepository.findAll(Sort.by("id").ascending());
    }

    @Override
    public List<Lights> getAllLights() {
        return lightsRepository.findAll();
    }

    @Override
    public Lights getLightsByID(Long id) {
        Optional<Lights> optionalLights = lightsRepository.findById(id);
        Lights lights = null;
        if(optionalLights.isPresent()){
            lights = optionalLights.get();
        }else {throw new RuntimeException("Service not found for ID :: " + id);
        }
        return lights;
    }

    @Override
    public Set<Lights> findAll() {
        return super.findAll();
    }

    @Override
    public Lights findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Lights save(Lights object) {
        return super.save(object);
    }

    @Override
    public void delete(Lights object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Lights findByLights(int motion) {
        return null;
    }
}
