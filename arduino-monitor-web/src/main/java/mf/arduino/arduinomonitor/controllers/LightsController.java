package mf.arduino.arduinomonitor.controllers;

import mf.arduino.arduinomonitor.model.LightsList;
import mf.arduino.arduinomonitor.repositories.LightsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/sensorsPages")
@Controller
public class LightsController {

    private final LightsRepository lightsRepository;

    public LightsController(LightsRepository lightsRepository) {
        this.lightsRepository = lightsRepository;
    }

    @RequestMapping({"/", "/lights", "/lights.html"})
    public String listLightsData(Map<String, Object> model){

        LightsList lightsList = new LightsList();

        lightsList.getLightsList().addAll(this.lightsRepository.findAll());

        model.put("lightsList", lightsList);




         return "sensorsPages/lights";
    }
}
