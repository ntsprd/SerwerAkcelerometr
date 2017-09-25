package accelerometer.server.model;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import java.io.Serializable;

@Table
public class Wynik implements Serializable {

    @PrimaryKey
    private UserTimestamp userTimestamp;

    private String wynik;

    public Wynik() {}

    public UserTimestamp getUserTimestamp() {
        return userTimestamp;
    }

    public void setUserTimestamp(UserTimestamp userTimestamp) {
        this.userTimestamp = userTimestamp;
    }

    public String getWynik() {
        return wynik;
    }

    public void setWynik(String wynik) {
        this.wynik = wynik;
    }
}