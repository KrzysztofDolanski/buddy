package dol.buddy;

import dol.buddy.addicted.Buddy;
import dol.buddy.time.TimeEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BuddyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuddyApplication.class, args);
        TimeEngine timeEngine = new TimeEngine();
        timeEngine.beepForAnHour();

//        Set<Buddy> set = new HashSet<>();
//
//        for (int i = 0; i < 4; i++) {
//            Buddy buddy = new Buddy("Jan"+i);
//            set.add(buddy);
//        }
//
//        System.out.println(set);
    }

}
