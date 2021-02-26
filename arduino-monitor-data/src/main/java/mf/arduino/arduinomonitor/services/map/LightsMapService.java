package mf.arduino.arduinomonitor.services.map;

import mf.arduino.arduinomonitor.model.Lights;
import mf.arduino.arduinomonitor.services.CrudService;

import java.util.Set;

public class LightsMapService extends AbstractMapService<Lights, Long> implements CrudService<Lights, Long> {

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
}
