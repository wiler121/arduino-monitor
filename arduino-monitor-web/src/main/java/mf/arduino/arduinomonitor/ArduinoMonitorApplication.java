package mf.arduino.arduinomonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ArduinoMonitorApplication {



    public static void main(String[] args) {
        SpringApplication.run(ArduinoMonitorApplication.class, args);}}
