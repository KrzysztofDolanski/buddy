package dol.buddy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Availability {

    Logger log = LoggerFactory.getLogger(Availability.class.getSimpleName());

    @EventListener
    public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
        switch (event.getState()) {
            case ACCEPTING_TRAFFIC -> {
                log.info("application ready");
            }
            case REFUSING_TRAFFIC -> {
                log.error("Application refused");
            }
        }
    }
}
