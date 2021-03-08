package mf.arduino.arduinomonitor.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mf.arduino.arduinomonitor.model.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class NotificationsController {

    private static final String MOTION_SCHEDULED_TASKS = "motionDetectNotification";
    private static final String TEMP_SCHEDULED_TASKS = "temperatureDetectNotification";
    private static final String HUM_SCHEDULED_TASKS = "humidityDetectNotification";
    private static final String CO2_SCHEDULED_TASKS = "co2DetectNotification";



    @Autowired
    private ScheduledAnnotationBeanPostProcessor postProcessor;

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping({"notifications"})
    public String notifications(Model model) throws JsonProcessingException {
        Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
        if(!setTasks.isEmpty()){
            System.out.println("Tasks running:" + objectMapper.writeValueAsString(setTasks));
        }else {
            System.out.println("no running tasks");
        }

        double tempMax = GlobalVariables.temperatureLevelForNotificationsForMax;
        double tempMin = GlobalVariables.temperatureLevelForNotificationsForMin;
        int humMax = GlobalVariables.humidityLevelForNotificationsForMAX;
        int humMin = GlobalVariables.humidityLevelForNotificationsForMIN;
        int co2 = GlobalVariables.co2LevelForNotifications;

        model.addAttribute("tempMin", tempMin);
        model.addAttribute("tempMax", tempMax);
        model.addAttribute("humMin", humMin);
        model.addAttribute("humMax", humMax);
        model.addAttribute("co2", co2);

        return "notifications";
    }

    @GetMapping(value = "notifications/stopScheduleSensor")
    public String stopScheduleSensor(){
        postProcessor.postProcessBeforeDestruction(scheduledTasks, TEMP_SCHEDULED_TASKS);
        postProcessor.postProcessBeforeDestruction(scheduledTasks, HUM_SCHEDULED_TASKS);
        postProcessor.postProcessBeforeDestruction(scheduledTasks, CO2_SCHEDULED_TASKS);
        return "redirect:/notifications";
    }
    @GetMapping(value = "notifications/startScheduleSensor")
    public String startScheduleSensor(){
        postProcessor.postProcessAfterInitialization(scheduledTasks, TEMP_SCHEDULED_TASKS);
        postProcessor.postProcessAfterInitialization(scheduledTasks, HUM_SCHEDULED_TASKS);
        postProcessor.postProcessAfterInitialization(scheduledTasks, CO2_SCHEDULED_TASKS);

        return "redirect:/notifications";
    }

    @RequestMapping(value = "notifications/saveNotificationVariables")
    public String saveNotificationVariables(double tempMin, double tempMax, int humMin, int humMax, int co2,Model model){

//        double tempMax = GlobalVariables.temperatureLevelForNotificationsForMax;
//        double tempMin = GlobalVariables.temperatureLevelForNotificationsForMin;
//        int humMax = GlobalVariables.humidityLevelForNotificationsForMAX;
//        int humMin = GlobalVariables.humidityLevelForNotificationsForMIN;
//        int co2 = GlobalVariables.co2LevelForNotifications;


        model.addAttribute("tempMin", tempMin);
        model.addAttribute("tempMax", tempMax);
        model.addAttribute("humMin", humMin);
        model.addAttribute("humMax", humMax);
        model.addAttribute("co2", co2);


        GlobalVariables.temperatureLevelForNotificationsForMin = tempMin;
        System.out.println(GlobalVariables.temperatureLevelForNotificationsForMin);

        GlobalVariables.temperatureLevelForNotificationsForMax = tempMax;
        System.out.println(GlobalVariables.temperatureLevelForNotificationsForMax);

        GlobalVariables.humidityLevelForNotificationsForMIN = humMin;
        System.out.println(GlobalVariables.temperatureLevelForNotificationsForMin);

        GlobalVariables.humidityLevelForNotificationsForMAX = humMax;
        System.out.println(GlobalVariables.humidityLevelForNotificationsForMAX);

        GlobalVariables.co2LevelForNotifications = co2;
        System.out.println(GlobalVariables.co2LevelForNotifications);

        return "notifications";
    }
}
