package dol.buddy.time;

import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public void saveEvent(EventEntity event) {
        repository.save(event);
    }
}
