package dol.buddy.time;

import static dol.buddy.time.EventsProducer.getOrdinaryDayEvents;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.springframework.stereotype.Component;

@Component
public class TimeEngine {

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
                System.out.println("beep");
            }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() {
                beeperHandle.cancel(true);
            }
        }, 60 * 60, SECONDS);

        Map<String, String> ordinaryDayEvents = getOrdinaryDayEvents();
        manager.subscribe("day", new TreeListener());
        return manager.notifyProducers("day", ordinaryDayEvents);
    }
}
