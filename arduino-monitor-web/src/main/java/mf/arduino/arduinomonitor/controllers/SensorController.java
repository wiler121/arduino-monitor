package mf.arduino.arduinomonitor.controllers;

import mf.arduino.arduinomonitor.services.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sensorsPages")
@Controller
public class SensorController {

    public final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @RequestMapping({"/", "/sensors", "/sensors.html"})
    public String listSensorsData(Model model){

        model.addAttribute("sensors", sensorService.findAll());
        return "sensorsPages/sensors";
    }
}
