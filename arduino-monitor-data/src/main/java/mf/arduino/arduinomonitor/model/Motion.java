package mf.arduino.arduinomonitor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motion")
public class Motion extends timestampEntity{

    @Column(name = "motion")
    int motion;

    public int getMotion() {
        return motion;
    }

    public void setMotion(int motion) {
        this.motion = motion;
    }
}
