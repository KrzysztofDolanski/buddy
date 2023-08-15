package dol.buddy.time;

import dol.buddy.forecast.Sun;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventsProducer {

    private static final String FORECAST = "forecast";
    private static final String WATER = "water";
    private static final String SUN = "sun";
    private static final String TEMPERATURE = "temperature";

    private static final Map<String, String> ordinaryDayEvents = Map.ofEntries(
            Map.entry(WATER, "100"),
            Map.entry(SUN, Sun.MEDIUM.name()),
            Map.entry(TEMPERATURE, "18"));

    protected String getEventValue(String event) {
        return ordinaryDayEvents.get(event);
    }

    public static Map<String, String> getOrdinaryDayEvents() {
        return ordinaryDayEvents;
    }

    protected String getWater() {
        return ordinaryDayEvents.get(WATER);
    }

    protected String getSun() {
        return ordinaryDayEvents.get(SUN);
    }

    protected String getTemperature() {
        return ordinaryDayEvents.get(TEMPERATURE);
    }
}
