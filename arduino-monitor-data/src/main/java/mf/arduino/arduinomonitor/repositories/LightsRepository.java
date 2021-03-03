package mf.arduino.arduinomonitor.repositories;


import mf.arduino.arduinomonitor.model.Lights;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface LightsRepository extends Repository<Lights, Long> {

    @Transactional(readOnly = true)
    @Cacheable("lightsList")
    Collection<Lights> findAll() throws DataAccessException;
}
