package mf.arduino.arduinomonitor.model;

public class Users extends BaseEntity{
    private String username;
    private String passowrd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
}
