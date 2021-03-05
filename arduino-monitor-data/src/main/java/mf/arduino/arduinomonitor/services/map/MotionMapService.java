package mf.arduino.arduinomonitor.services.map;

import mf.arduino.arduinomonitor.model.Motion;
import mf.arduino.arduinomonitor.repositories.MotionRepository;
import mf.arduino.arduinomonitor.services.MotionService;
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
public class MotionMapService extends AbstractMapService<Motion, Long> implements MotionService {

    @Autowired
    MotionRepository motionRepository;

    @Override
    public Page<Motion> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, String startDate, String endDate) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.motionRepository.findBetweenDates(startDate,endDate,pageable);
    }

    @Override
    public List<Motion> findTop() {
        return this.motionRepository.findLatest();
    }

    @Override
    public List<Motion> listAll() {
        return motionRepository.findAll(Sort.by("id").descending());
    }

    @Override
    public List<Motion> getAllMotions() {
        return motionRepository.findAll();
    }

    @Override
    public Motion GetMotionById(Long id) {
        Optional<Motion> motionOptional = motionRepository.findById(id);
        Motion motion = null;
        if(motionOptional.isPresent()){
            motion = motionOptional.get();
        }else {throw new RuntimeException("Service not found for ID :: " + id);
        }
        return motion;
    }

    @Override
    public Set<Motion> findAll() {
        return super.findAll();
    }

    @Override
    public Motion findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Motion save(Motion object) {
        return super.save(object);
    }

    @Override
    public void delete(Motion object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Motion findByMotion(int motion) {
        return null;
    }
}
