package mf.arduino.arduinomonitor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lights")
public class Lights extends timestampEntity{

    @Column(name = "light_level")
    int lightLevel;


    public int getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }
}
