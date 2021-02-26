package mf.arduino.arduinomonitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sensorsPages")
@Controller
public class SensorController {

    @RequestMapping({"/", "/sensors", "/sensors.html"})
    public String listSensorsData(){
        return "sensorsPages/sensors";
    }
}
