package dol.buddy.time;

import dol.buddy.forecast.Sun;
import dol.buddy.forecast.Temperature;
import dol.buddy.forecast.Water;
import lombok.Getter;
import lombok.ToString;
import net.bytebuddy.utility.RandomString;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Getter
@ToString
public class TreeListener implements EventListener {

    private String water;
    private final String sun;
    private final String temperature;
    private String alive;

    public TreeListener() {
        this.water = waterGenerator();
        this.sun = sunGenerator();
        this.temperature = temperatureGenerator();
        this.alive = alive;
    }

    private String temperatureGenerator() {
        int length = Temperature.values().length;
        int random = new Random().nextInt(length);
        int degrees = new Random().nextInt(41);
        String name = Temperature.values()[random].name();
        return name.equals(Temperature.ZERO.name()) ? name : name.concat(" " + degrees);
    }

    private String sunGenerator() {
        int length = Sun.values().length;
        int random = new Random().nextInt(length);
        return Sun.values()[random].name();
    }

    private String waterGenerator() {
        int length = Water.values().length;
        int random = new Random().nextInt(length);
        return Water.values()[random].name();
    }

    @Override
    public void update(String eventType, Map<String, String> data) {
        if (Optional.ofNullable(this.alive).isPresent() && this.alive.equals("true")) {
            if (data.containsKey(water)) {
                this.water = data.get(water);
            } else {
                //todo add some events
            }
        }
    }
}
