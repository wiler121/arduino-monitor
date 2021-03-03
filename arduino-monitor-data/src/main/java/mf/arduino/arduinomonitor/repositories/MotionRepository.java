package mf.arduino.arduinomonitor.repositories;

import mf.arduino.arduinomonitor.model.Motion;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface MotionRepository extends Repository<Motion, Long> {


    @Transactional(readOnly = true)
    @Cacheable("motionList")
    Collection<Motion> findAll() throws DataAccessException;



}
