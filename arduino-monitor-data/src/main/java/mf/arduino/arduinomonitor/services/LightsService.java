package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.Lights;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LightsService extends CrudService<Lights, Long> {

    Lights findByLights(int motion);
    List<Lights> getAllLights();
    Lights getLightsByID(Long id);
    public Page<Lights> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection,String startDate, String endDate);
    public List<Lights> listAll();
    public List<Lights> findLatestLight();


}
