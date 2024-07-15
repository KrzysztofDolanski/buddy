package dol.buddy.time;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TimeController {

    private final EventService service;
    private final EventsProducer eventsProducer;

    @GetMapping("/day")
    public void day(){
        TimeEngine timeEngine = new TimeEngine(eventsProducer);
        service.saveEvent(timeEngine.beepForAnHour());
    }
}
