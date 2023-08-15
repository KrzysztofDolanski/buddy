package dol.buddy;

import dol.buddy.time.TimeEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class BuddyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuddyApplication.class, args);
    }

}
