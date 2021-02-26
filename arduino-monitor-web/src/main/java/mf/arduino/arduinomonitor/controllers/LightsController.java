package mf.arduino.arduinomonitor.controllers;

import mf.arduino.arduinomonitor.services.LightsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sensorsPages")
@Controller
public class LightsController {

    private final LightsService lightsService;

    public LightsController(LightsService lightsService) {
        this.lightsService = lightsService;
    }

    @RequestMapping({"/", "/lights", "/lights.html"})
    public String listLightsData(Model model){

        model.addAttribute("lights", lightsService.findAll());

         return "sensorsPages/lights";
    }
}
