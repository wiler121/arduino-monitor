package mf.arduino.arduinomonitor.repositories;

import mf.arduino.arduinomonitor.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

}



