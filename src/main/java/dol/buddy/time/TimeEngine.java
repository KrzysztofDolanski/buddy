package dol.buddy.time;

import dol.buddy.forecast.Sun;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TimeEngine {

    private EventManager manager;
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {


        manager = new EventManager();
        final Runnable beeper = new Runnable() {
            public void run() {
                //todo dodawanie eventów dla każdego kolejnego dnia
                manager.notify("day", new HashMap<>());
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
    }
}
