package mf.arduino.arduinomonitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sensorsPages")
@Controller
public class LightsController {

    @RequestMapping({"/", "/lights", "/lights.html"})
    public String listLightsData(){
        return "sensorsPages/lights";
    }
}
