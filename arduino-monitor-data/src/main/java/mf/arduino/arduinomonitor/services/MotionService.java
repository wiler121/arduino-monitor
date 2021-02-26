package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.Motion;

public interface MotionService extends CrudService<Motion, Long>{

    Motion findByMotion(int motion);

}
