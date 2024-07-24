package dol.buddy.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class TimeEngine {

    private Object lock = new Object();

    Logger log = LoggerFactory.getLogger(TimeEngine.class.getSimpleName());
    private final EventManager manager;
    private final EventsProducer eventsProducer;
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    @Autowired
    public TimeEngine(EventsProducer eventsProducer) {
        this.eventsProducer = eventsProducer;
        this.manager = new EventManager();
    }

    @Bean
    public EventEntity beepForAnHour() {
        final Runnable beeper = new Runnable() {
                public void run() {

                    synchronized (lock) {
                        List<EventListener> day = manager.getListeners().get("day");
                        for (EventListener eventListener : day) {
                            TreeListener day1 = (TreeListener) eventListener;
                            log.info(day1.toString());
                        }

                        createEvents();
                    }

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

        return createEvents();
    }

    private EventEntity createEvents() {
        Map<String, String> ordinaryDayEvents = eventsProducer.getOrdinaryDayEvents();
        manager.subscribe("day", new TreeListener());
        return manager.notifyProducers("day", ordinaryDayEvents);
    }

}
