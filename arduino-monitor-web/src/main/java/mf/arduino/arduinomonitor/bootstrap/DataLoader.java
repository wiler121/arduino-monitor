package mf.arduino.arduinomonitor.bootstrap;

import mf.arduino.arduinomonitor.model.Lights;
import mf.arduino.arduinomonitor.model.Motion;
import mf.arduino.arduinomonitor.model.Sensor;
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

        int test;

        Lights lights1 = new Lights();
        lights1.setLightLevel(384);

        lightsService.save(lights1);

        Lights lights2 = new Lights();
        lights2.setLightLevel(321);

        lightsService.save(lights2);

        Motion motion1 = new Motion();
        motion1.setMotion(1);

        motionService.save(motion1);

        Motion motion2 = new Motion();
        motion2.setMotion(1);

        motionService.save(motion2);

        Sensor sensor1 = new Sensor();
        sensor1.setTemperature(22.3);
        sensor1.setHumidity(48);
        sensor1.setC02(26);
        sensorService.save(sensor1);

        Sensor sensor2 = new Sensor();
        sensor2.setTemperature(22.4);
        sensor2.setHumidity(47);
        sensor2.setC02(25);
        sensorService.save(sensor2);

        System.out.println("Data Loaded...");


    }
}
