package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.Motion;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MotionService extends CrudService<Motion, Long>{

    Motion findByMotion(int motion);
    List<Motion> getAllMotions();
    Motion GetMotionById(Long id);
    public Page<Motion> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
    public List<Motion> listAll();
    public List<Motion> findTop();


}
