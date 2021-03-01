package mf.arduino.arduinomonitor.services.map;

import mf.arduino.arduinomonitor.model.Sensor;
import mf.arduino.arduinomonitor.services.SensorService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SensorMapService extends AbstractMapService<Sensor, Long> implements SensorService {

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
        return super.save(object);
    }

    @Override
    public void delete(Sensor object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Sensor findByTemp(int temp) {
        return null;
    }

    @Override
    public Sensor findByHum(int hum) {
        return null;
    }

    @Override
    public Sensor findByCO2(int co2) {
        return null;
    }
}
