package mf.arduino.arduinomonitor.repositories;

import mf.arduino.arduinomonitor.model.Sensor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface SensorRepository extends CrudRepository<Sensor, Long> {

    @Transactional(readOnly = true)
    @Cacheable("sensorsList")
    Collection<Sensor> findAll() throws DataAccessException;

}
