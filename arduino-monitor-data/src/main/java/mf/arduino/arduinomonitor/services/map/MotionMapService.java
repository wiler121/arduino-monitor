package mf.arduino.arduinomonitor.services.map;

import mf.arduino.arduinomonitor.model.Motion;
import mf.arduino.arduinomonitor.services.CrudService;

import java.util.Set;

public class MotionMapService extends AbstractMapService<Motion, Long> implements CrudService<Motion, Long> {

    @Override
    public Set<Motion> findAll() {
        return super.findAll();
    }

    @Override
    public Motion findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Motion save(Motion object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Motion object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
