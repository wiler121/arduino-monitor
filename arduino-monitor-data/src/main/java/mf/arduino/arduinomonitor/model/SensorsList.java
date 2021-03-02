package mf.arduino.arduinomonitor.model;

import java.util.ArrayList;
import java.util.List;

public class SensorsList {

    private List<Sensor> sensorsList;

    public List<Sensor> getSensorsList() {
        if (sensorsList == null) {
            sensorsList = new ArrayList<>();
        }
        return sensorsList;
    }
}

