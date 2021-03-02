package mf.arduino.arduinomonitor.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
public class timestampEntity extends BaseEntity {

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
