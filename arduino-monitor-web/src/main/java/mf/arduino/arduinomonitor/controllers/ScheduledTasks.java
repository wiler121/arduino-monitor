package mf.arduino.arduinomonitor.controllers;

import mf.arduino.arduinomonitor.model.GlobalVariables;
import mf.arduino.arduinomonitor.model.Motion;
import mf.arduino.arduinomonitor.model.Sensor;
import mf.arduino.arduinomonitor.repositories.MotionRepository;
import mf.arduino.arduinomonitor.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class ScheduledTasks {

    @Autowired
    MotionRepository motionRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    ApplicationContext appContext;

    @Autowired
    NotificationsMailSender notificationsMailSender;

    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date currentTime;

    @Scheduled(fixedRate = 60000)
    public void motionDetectNotification(){

        String problem = "WYKRYTO RUCH";
        String problemDesc= currentTime+" \n Wyryto ruch";

        Motion[] motionsArray = motionRepository.findLatestArrayList();

        if (motionsArray[0].getMotion() == 1){
            currentTime = new Date(System.currentTimeMillis());
            notificationsMailSender.sendMotionMail(problem,problemDesc,currentTime);
        }

    }

    @Scheduled(fixedRate = 60000)
    public void temperatureDetectNotification(){
        String problem = "TEMPERATURA PRZEKROCZONA";
        String problemDescMAX = currentTime + "\n TEMPERATURA PRZEKROCZONA";
        String problemDescMIN = currentTime + "\n TEMPERATURA ZA NISKA";

        Sensor[] sensorsArray = sensorRepository.findLatestArrayList();

        if (sensorsArray[0].getTemperature() > GlobalVariables.temperatureLevelForNotificationsForMax){
            currentTime = new Date(System.currentTimeMillis());
            notificationsMailSender.sendSensorsMail(problem,problemDescMAX,currentTime,sensorsArray[0].getTemperature(),
                    sensorsArray[0].getHumidity(), sensorsArray[0].getCo2());
        } else if (sensorsArray[0].getTemperature() < GlobalVariables.temperatureLevelForNotificationsForMin){
            currentTime = new Date(System.currentTimeMillis());
            notificationsMailSender.sendSensorsMail(problem,problemDescMIN,currentTime,sensorsArray[0].getTemperature(),
                    sensorsArray[0].getHumidity(), sensorsArray[0].getCo2());
        }
    }

    @Scheduled(fixedRate = 60000)
    public void humidityDetectNotification(){
        String problem = "PROBLEM Z WILGOTNOSCIA";
        String problemDescMAX = currentTime + "\n WILGOTNOSC PRZEKROCZONA";
        String problemDescMIX = currentTime + "\n WILGOTNOSC ZA NISKA";

        Sensor[] sensorsArray = sensorRepository.findLatestArrayList();
        System.out.println(GlobalVariables.temperatureLevelForNotificationsForMin);
        System.out.println(GlobalVariables.temperatureLevelForNotificationsForMax);
        System.out.println(GlobalVariables.humidityLevelForNotificationsForMIN);
        System.out.println(GlobalVariables.humidityLevelForNotificationsForMAX);
        System.out.println(GlobalVariables.co2LevelForNotifications);

        if (sensorsArray[0].getHumidity() > GlobalVariables.humidityLevelForNotificationsForMAX){
            currentTime = new Date(System.currentTimeMillis());
            notificationsMailSender.sendSensorsMail(problem,problemDescMAX,currentTime,sensorsArray[0].getTemperature(),
                    sensorsArray[0].getHumidity(), sensorsArray[0].getCo2());
        } else if (sensorsArray[0].getHumidity() < GlobalVariables.humidityLevelForNotificationsForMIN){
            currentTime = new Date(System.currentTimeMillis());
            notificationsMailSender.sendSensorsMail(problem,problemDescMIX,currentTime,sensorsArray[0].getTemperature(),
                    sensorsArray[0].getHumidity(), sensorsArray[0].getCo2());
        };
    }

    @Scheduled(fixedRate = 60000)
    public void co2DetectNotification(){
        String problem = "PROBLEM Z Co2";
        String problemDesc = currentTime + "\n STEZENIE Co2 PRZEKROCZONE";

        Sensor[] sensorsArray = sensorRepository.findLatestArrayList();

        if (sensorsArray[0].getCo2() > GlobalVariables.co2LevelForNotifications){
            notificationsMailSender.sendSensorsMail(problem,problemDesc,currentTime,sensorsArray[0].getTemperature(),
                    sensorsArray[0].getHumidity(), sensorsArray[0].getCo2());
        }
    }
}
