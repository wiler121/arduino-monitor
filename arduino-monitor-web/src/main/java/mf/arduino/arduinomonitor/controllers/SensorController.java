package mf.arduino.arduinomonitor.controllers;

import mf.arduino.arduinomonitor.model.SensorsList;
import mf.arduino.arduinomonitor.repositories.SensorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/sensorsPages")
@Controller
public class SensorController {

    private final SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }



    @RequestMapping({"/", "/sensors", "/sensors.html"})
    public String listSensorsData(Map<String, Object> model){

        SensorsList sensorsList = new SensorsList();

        sensorsList.getSensorsList().addAll(this.sensorRepository.findAll());
        model.put("sensorsList", sensorsList);

        return "sensorsPages/sensors";
    }


}
