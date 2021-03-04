package mf.arduino.arduinomonitor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor extends timestampEntity{

    @Column(name = "humidity")
    private int humidity;
    @Column(name = "temperature")
    private double temperature;
    @Column(name = "co2")
    private int co2;


    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }
}
