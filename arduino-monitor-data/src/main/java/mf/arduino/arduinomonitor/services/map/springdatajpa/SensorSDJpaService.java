package mf.arduino.arduinomonitor.services.map.springdatajpa;

import mf.arduino.arduinomonitor.model.Sensor;
import mf.arduino.arduinomonitor.repositories.SensorRepository;
import mf.arduino.arduinomonitor.services.SensorService;

import java.util.Set;

public class SensorSDJpaService implements SensorService {

    private final SensorRepository sensorRepository;

    public SensorSDJpaService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Set<Sensor> findAll() {
        return null;
    }

    @Override
    public Sensor findById(Long aLong) {
        return null;
    }

    @Override
    public Sensor save(Sensor object) {
        return null;
    }

    @Override
    public void delete(Sensor object) {

    }

    @Override
    public void deleteById(Long aLong) {

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
