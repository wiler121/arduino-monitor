package mf.arduino.arduinomonitor.controllers;

import mf.arduino.arduinomonitor.model.Lights;
import mf.arduino.arduinomonitor.model.Motion;
import mf.arduino.arduinomonitor.model.Sensor;
import mf.arduino.arduinomonitor.services.map.LightsMapService;
import mf.arduino.arduinomonitor.services.map.MotionMapService;
import mf.arduino.arduinomonitor.services.map.SensorMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    MotionMapService motionMapService;

    @Autowired
    SensorMapService sensorMapService;

    @Autowired
    LightsMapService lightsMapService;


    @RequestMapping({ "index.html"})
    public String index(Model model){

        List<Motion> motionListIndex = motionMapService.findTop();
        List<Sensor> sensorListIndex = sensorMapService.findTopSensor();
        List<Lights> lightsListIndex = lightsMapService.findLatestLight();

        model.addAttribute("motionListIndex", motionListIndex);
        model.addAttribute("sensorListIndex", sensorListIndex);
        model.addAttribute("lightsListIndex", lightsListIndex);



        return "index";
    }
}
