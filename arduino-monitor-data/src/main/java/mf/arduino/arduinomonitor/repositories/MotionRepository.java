package mf.arduino.arduinomonitor.repositories;

import mf.arduino.arduinomonitor.model.Motion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotionRepository extends JpaRepository<Motion, Long> {

}
