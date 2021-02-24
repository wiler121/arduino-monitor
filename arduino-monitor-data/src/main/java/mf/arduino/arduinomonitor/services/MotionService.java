package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.Motion;

import java.util.Set;

public interface MotionService {
    Motion findByMotion(int motion);

    Motion save(Motion motion);

    Set<Motion> findAll();
}
