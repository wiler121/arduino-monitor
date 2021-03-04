package mf.arduino.arduinomonitor.services;

import mf.arduino.arduinomonitor.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
