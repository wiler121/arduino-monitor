package mf.arduino.arduinomonitor.repositories;

import mf.arduino.arduinomonitor.model.Motion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MotionRepository extends JpaRepository<Motion, Long> {
    @Query(nativeQuery = true, value = "SELECT * from motion ORDER BY id DESC LIMIT 1")
    List<Motion> findLatest();
}


