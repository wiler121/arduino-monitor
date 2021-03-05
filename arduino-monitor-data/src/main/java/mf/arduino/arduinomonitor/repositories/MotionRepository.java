package mf.arduino.arduinomonitor.repositories;

import mf.arduino.arduinomonitor.model.Motion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MotionRepository extends JpaRepository<Motion, Long> {
    @Query(nativeQuery = true, value = "SELECT * from motion ORDER BY id DESC LIMIT 1")
    List<Motion> findLatest();

    @Query(nativeQuery = true, value = "select * from motion Where timestamp BETWEEN :startDate AND :endDate")
    Page<Motion> findBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable);
}


