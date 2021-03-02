package mf.arduino.arduinomonitor.model;

public class Lights extends BaseEntity{
    int lightLevel;


    public int getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }
}
