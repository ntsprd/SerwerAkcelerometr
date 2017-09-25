package accelerometer.server.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Pomiar {

    public static final String DEFAULT_USER = "UZYTKOWNIK";

    @PrimaryKey
    @NotNull
    private UserTimestamp user_timestamp;

    @Column
    @NotNull
    private Double x;

    @Column
    @NotNull
    private Double y;

    @Column
    @NotNull
    private Double z;

    public Pomiar() {}

    public Pomiar(PomiarModel pomiarModel) {
        user_timestamp = new UserTimestamp();
        user_timestamp.setTimestamp(pomiarModel.getTimestamp());
        user_timestamp.setUser_id(DEFAULT_USER);
        x = pomiarModel.getX();
        y = pomiarModel.getY();
        z = pomiarModel.getZ();
    }

    public UserTimestamp getUser_timestamp() {
        return user_timestamp;
    }

    public void setUser_timestamp(UserTimestamp user_timestamp) {
        this.user_timestamp = user_timestamp;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "[timestamp: " + user_timestamp + ", x: " + x + ", y: " + y + ", z: " + z + ']';
    }
}


