package dol.buddy.time;

import java.util.Map;

public interface EventListener {
    void update(String eventType, Map<String, String> data);
}
