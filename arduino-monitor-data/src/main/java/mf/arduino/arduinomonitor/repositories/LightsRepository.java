package mf.arduino.arduinomonitor.repositories;


import mf.arduino.arduinomonitor.model.Lights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightsRepository extends JpaRepository<Lights, Long> {

}
