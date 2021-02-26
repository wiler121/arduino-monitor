package mf.arduino.arduinomonitor.bootstrap;

import mf.arduino.arduinomonitor.model.Lights;
import mf.arduino.arduinomonitor.model.Motion;
import mf.arduino.arduinomonitor.services.LightsService;
import mf.arduino.arduinomonitor.services.MotionService;
import mf.arduino.arduinomonitor.services.map.LightsMapService;
import mf.arduino.arduinomonitor.services.map.MotionMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final LightsService lightsService;
    private final MotionService motionService;


    public DataLoader() {
        lightsService = new LightsMapService();
        motionService = new MotionMapService();
    }

    @Override
    public void run(String... args) throws Exception {

        Lights lights1 = new Lights();
        lights1.setId(1L);
        lights1.setLightLevel(384);

        lightsService.save(lights1);

        Lights lights2 = new Lights();
        lights2.setId(2L);
        lights2.setLightLevel(321);

        lightsService.save(lights2);

        Motion motion1 = new Motion();
        motion1.setId(1L);
        motion1.setMotion(1);

        motionService.save(motion1);

        Motion motion2 = new Motion();
        motion2.setId(2L);
        motion2.setMotion(1);

        motionService.save(motion2);

        System.out.println("Data Loaded...");


    }
}
