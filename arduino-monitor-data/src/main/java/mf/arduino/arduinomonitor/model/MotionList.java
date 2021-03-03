package mf.arduino.arduinomonitor.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class MotionList {

    private List<Motion> motionList;

    @XmlElement
    public  List<Motion> getMotionList(){
        if(motionList == null){
            motionList = new ArrayList<>();
        }
        return motionList;
    }
}
