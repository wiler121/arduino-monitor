package mf.arduino.arduinomonitor.services.map;

import mf.arduino.arduinomonitor.model.Sensor;
import mf.arduino.arduinomonitor.services.CrudService;

import java.util.Set;

public class SensorMapService extends AbstractMapService<Sensor, Long> implements CrudService<Sensor, Long> {

    @Override
    public Set<Sensor> findAll() {
        return super.findAll();
    }

    @Override
    public Sensor findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Sensor save(Sensor object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Sensor object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
