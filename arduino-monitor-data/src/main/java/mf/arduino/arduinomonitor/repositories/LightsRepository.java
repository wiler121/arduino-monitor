package mf.arduino.arduinomonitor.repositories;


import mf.arduino.arduinomonitor.model.Lights;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LightsRepository extends JpaRepository<Lights, Long> {

    @Query(nativeQuery = true, value = "SELECT * from lights ORDER BY id DESC LIMIT 1")
    List<Lights> findLatestLights();

    @Query(nativeQuery = true, value = "select * from lights Where timestamp BETWEEN :startDate AND :endDate ORDER BY id LIMIT 999999")
    Page<Lights> findBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable);

}
