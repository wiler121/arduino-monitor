package mf.arduino.arduinomonitor.model;

public class Sensor extends BaseEntity{

    private int humidity;
    private double temperature;
    private int c02;

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

    public int getC02() {
        return c02;
    }

    public void setC02(int c02) {
        this.c02 = c02;
    }
}
