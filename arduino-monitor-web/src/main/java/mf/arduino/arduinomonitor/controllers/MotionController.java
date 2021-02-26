package mf.arduino.arduinomonitor.controllers;

import mf.arduino.arduinomonitor.services.MotionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sensorsPages")
@Controller
public class MotionController {

    private final MotionService motionService;

    public MotionController(MotionService motionService) {
        this.motionService = motionService;
    }

    @RequestMapping({"/", "/motion", "/motion.html"})
    public String listMotionData(Model model){

        model.addAttribute("motions", motionService.findAll());
        return "sensorsPages/motion";
    }
}
