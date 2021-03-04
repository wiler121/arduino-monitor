package mf.arduino.arduinomonitor.bootstrap;

import mf.arduino.arduinomonitor.services.LightsService;
import mf.arduino.arduinomonitor.services.MotionService;
import mf.arduino.arduinomonitor.services.SensorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final LightsService lightsService;
    private final MotionService motionService;
    private final SensorService sensorService;


    public DataLoader(LightsService lightsService, MotionService motionService, SensorService sensorService) {
        this.lightsService = lightsService;
        this.motionService = motionService;
        this.sensorService = sensorService;
    }

    @Override
    public void run(String... args) {



        System.out.println("Data Loaded...");


    }
}
