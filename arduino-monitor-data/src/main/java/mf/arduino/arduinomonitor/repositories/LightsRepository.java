package mf.arduino.arduinomonitor.repositories;


import mf.arduino.arduinomonitor.model.Lights;
import org.springframework.data.repository.CrudRepository;

public interface LightsRepository extends CrudRepository<Lights, Long> {
}
