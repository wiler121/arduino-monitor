package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.Lights;

import java.util.Set;

public interface LightsService {

    Lights findByMLights(int motion);

    Lights save(Lights lights);

    Set<Lights> findAll();
}
