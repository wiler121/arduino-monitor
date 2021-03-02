package mf.arduino.arduinomonitor.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseEntity implements Serializable {

    private Long id;

    private Timestamp timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
