package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.Sensor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SensorService extends CrudService<Sensor, Long>{


    List<Sensor> getAllSensors();
    Sensor getSensorById(Long id);
    public Page<Sensor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
    public List<Sensor> listAll();
    Sensor findByTemp(int temp);
    Sensor findByHum(int hum);
    Sensor findByCO2(int co2);
    public List<Sensor> findTopSensor();

}
