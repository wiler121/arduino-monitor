package mf.arduino.arduinomonitor.services.map;

import mf.arduino.arduinomonitor.model.Lights;
import mf.arduino.arduinomonitor.services.LightsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LightsMapService extends AbstractMapService<Lights, Long> implements LightsService {

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
        return super.save(object.getId(), object);
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
