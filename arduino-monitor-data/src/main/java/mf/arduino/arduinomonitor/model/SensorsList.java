package mf.arduino.arduinomonitor.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class SensorsList {

    private List<Sensor> sensorsList;

    @XmlElement
    public List<Sensor> getSensorsList() {
        if (sensorsList == null) {
            sensorsList = new ArrayList<>();
        }
        return sensorsList;
    }
}

