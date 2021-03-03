package mf.arduino.arduinomonitor.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class LightsList {

    private List<Lights> lightsList;

    @XmlElement
    public List<Lights> getLightsList() {
        if (lightsList == null) {
            lightsList = new ArrayList<>();
        }
        return lightsList;
    }
}
