package mf.arduino.arduinomonitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sensorsPages")
@Controller
public class MotionController {

    @RequestMapping({"/", "/motion", "/motion.html"})
    public String listMotionData(){
        return "sensorsPages/motion";
    }
}
