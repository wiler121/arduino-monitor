package mf.arduino.arduinomonitor.controllers;

import mf.arduino.arduinomonitor.model.MotionList;
import mf.arduino.arduinomonitor.repositories.MotionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/sensorsPages")
@Controller
public class MotionController {

    private final MotionRepository motionRepository;

    public MotionController(MotionRepository motionRepository) {
        this.motionRepository = motionRepository;
    }

    @RequestMapping({"/", "/motion", "/motion.html"})
    public String listMotionData(Map<String, Object> model){

        MotionList motionList = new MotionList();

        motionList.getMotionList().addAll(this.motionRepository.findAll());
        model.put("motionList", motionList);

        return "sensorsPages/motion";
    }
}
