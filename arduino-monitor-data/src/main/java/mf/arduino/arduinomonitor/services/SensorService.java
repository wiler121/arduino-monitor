package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.Sensor;

import java.util.Set;

public interface SensorService {

    Sensor save(Sensor sensor);
    Set<Sensor> findAll();



}
