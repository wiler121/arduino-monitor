package mf.arduino.arduinomonitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SensorController {

    @RequestMapping({"/sensors", "/sensors/sensors", "/sensors/sensors/html"})
    public String listSensorsData(){
        return "sensors/sensors";
    }
}
