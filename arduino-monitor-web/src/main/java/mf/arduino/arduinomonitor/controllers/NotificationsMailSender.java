package mf.arduino.arduinomonitor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class NotificationsMailSender {

    String from = "arduinomotnior0@gmail.com";
    String to = "wilerek@gmail.com";
    SimpleMailMessage message = new SimpleMailMessage();


    @Autowired
    JavaMailSender javaMailSender;

    public void sendMotionMail(String problem, String problemDesc, Date currentDate) {

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("ARDUINO MONITOR " + problem);
        message.setText("Hello guys! This is a plain text email. \n " + problemDesc + " " + currentDate);

        javaMailSender.send(message);

    }

    public void sendSensorsMail(String problem, String problemDesc, Date currentDate, double temp, int hum, int co2) {
        String from = "arduinomotnior0@gmail.com";
        String to = "wilerek@gmail.com";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("SENSORS ALERT " + problem);
        message.setText("Hello guys! This is a plain text email. \n " + problemDesc + " " + currentDate +
                "\ntemperatura " + temp +
                "\nhumidity " + hum +
                "\nco2 " + co2);

        javaMailSender.send(message);
    }
}