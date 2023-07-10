package dol.buddy.time;

import java.util.Map;

public class TreeListener implements EventListener{

    private String water;
    private String sun;
    private String temperature;
    private String alive;
    @Override
    public void update(String eventType, Map<String, String> data) {
        if (this.alive.equals("true")) {
            if (data. containsKey(water)){
                this.water = data.get(water);

            }
        }
    }
}
