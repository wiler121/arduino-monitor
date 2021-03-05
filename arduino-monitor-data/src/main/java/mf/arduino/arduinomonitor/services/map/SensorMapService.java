package mf.arduino.arduinomonitor.services.map;

import mf.arduino.arduinomonitor.model.Sensor;
import mf.arduino.arduinomonitor.repositories.SensorRepository;
import mf.arduino.arduinomonitor.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SensorMapService extends AbstractMapService<Sensor, Long> implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public Set<Sensor> findAll() {
        return super.findAll();
    }

    @Override
    public Sensor findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Sensor save(Sensor object) {
        return super.save(object);
    }

    @Override
    public void delete(Sensor object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Sensor findByTemp(int temp) {
        return null;
    }

    @Override
    public Sensor findByHum(int hum) {
        return null;
    }

    @Override
    public Sensor findByCO2(int co2) {
        return null;
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor getSensorById(Long id) {
        Optional<Sensor> optionalSensor = sensorRepository.findById(id);
        Sensor sensor = null;
        if(optionalSensor.isPresent()){
            sensor = optionalSensor.get();
        }else {throw new RuntimeException("Service not found for ID :: " + id);
        }
        return sensor;
    }

    @Override
    public Page<Sensor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.sensorRepository.findAll(pageable);
    }

    @Override
    public List<Sensor> listAll() {
        return sensorRepository.findAll(Sort.by("id").ascending());
    }

    @Override
    public List<Sensor> findTopSensor() {
        return this.sensorRepository.findLatestSensor();
    }
}


