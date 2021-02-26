package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.Lights;

public interface LightsService extends CrudService<Lights, Long> {

    Lights findByLights(int motion);

}
