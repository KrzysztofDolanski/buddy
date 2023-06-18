package dol.buddy;

import dol.buddy.time.TimeEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuddyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuddyApplication.class, args);
        TimeEngine timeEngine = new TimeEngine();
        timeEngine.beepForAnHour();
    }

}
