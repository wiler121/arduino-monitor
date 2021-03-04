package mf.arduino.arduinomonitor.repositories;

import mf.arduino.arduinomonitor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
