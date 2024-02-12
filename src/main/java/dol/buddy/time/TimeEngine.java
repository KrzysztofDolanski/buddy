package dol.buddy.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static dol.buddy.time.EventsProducer.getOrdinaryDayEvents;
import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class TimeEngine {

    private Object lock = new Object();
    Logger log = LoggerFactory.getLogger(TimeEngine.class.getSimpleName());
    private final EventManager manager;
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public TimeEngine() {
        this.manager = new EventManager();
    }

    public EventEntity beepForAnHour() {
        final Runnable beeper = new Runnable() {
                public void run() {
                    //todo dodawanie eventów dla każdego kolejnego dnia
                    log.info("beep");
                }
            };

            final ScheduledFuture<?> beeperHandle =
                    scheduler.scheduleAtFixedRate(beeper, 2, 2, SECONDS);
            scheduler.schedule(new Runnable() {
                public void run() {
                    beeperHandle.cancel(true);
                }
            }, 30, SECONDS);

            Map<String, String> ordinaryDayEvents = getOrdinaryDayEvents();
            manager.subscribe("day", new TreeListener());
            return manager.notifyProducers("day", ordinaryDayEvents);
        }
}
