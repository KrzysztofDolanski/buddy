package dol.buddy.time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EventManager {

    private Map<String, List<EventListener>> listeners = new HashMap<>();

    @Autowired
    public EventManager(String... operations) {
        if (operations.length<1){
            listeners.put("day", new ArrayList<>());
            listeners.put("night", new ArrayList<>());
        }
        for (String operation : operations) {
            listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public EventEntity notifyProducers(String eventType, Map<String, String> file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
        return new EventEntity(eventType, file);
    }

    public Map<String, List<EventListener>> getListeners() {
        return listeners;
    }
}
