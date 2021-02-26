package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.Sensor;

public interface SensorService extends CrudService<Sensor, Long>{

    Sensor findByTemp(int temp);
    Sensor findByHum(int hum);
    Sensor findByCO2(int co2);

}
