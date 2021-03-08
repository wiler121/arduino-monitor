package mf.arduino.arduinomonitor.repositories;

import mf.arduino.arduinomonitor.model.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {


    @Query(nativeQuery = true, value = "SELECT * from sensor ORDER BY id DESC LIMIT 1")
    List<Sensor> findLatestSensor();

    @Query(nativeQuery = true, value = "SELECT * from sensor ORDER BY id DESC LIMIT 1")
    Sensor[] findLatestArrayList();

    @Query(nativeQuery = true, value = "select * from sensor Where timestamp BETWEEN :startDate AND :endDate")
    Page<Sensor> findBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable);
}




