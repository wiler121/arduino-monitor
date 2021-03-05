package mf.arduino.arduinomonitor.repositories;

import mf.arduino.arduinomonitor.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {


    @Query(nativeQuery = true, value = "SELECT * from sensor ORDER BY id DESC LIMIT 1")
    List<Sensor> findLatestSensor();
}




