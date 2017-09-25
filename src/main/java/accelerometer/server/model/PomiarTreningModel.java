package accelerometer.server.model;

import javax.validation.constraints.NotNull;

public class PomiarTreningModel{

    @NotNull
    private String userID;

    @NotNull
    private String activity;

    @NotNull
    private PomiarModel pomiar;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getActivity() {
        return activity;
    }

    public void setAktywnosc(String aktywnosc) {
        this.activity = activity;
    }

    public PomiarModel getPomiar() {
        return pomiar;
    }

    public void setPomiar(PomiarModel pomiar) {
        this.pomiar = pomiar;
    }

    @Override
    public String toString() {
        return "PomiarTreningModel{" +
                "ID='" + userID + '\'' +
                ", aktywnosc='" + activity + '\'' +
                ", pomiar=" + pomiar +
                '}';
    }
}
