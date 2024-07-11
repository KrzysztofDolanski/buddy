package dol.buddy.addicted;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Component
public class BuddySoul implements Serializable {

    private UUID uuid = UUID.randomUUID();
    private String name = "Buddy soul";

    private final transient BuddyService service;

    public BuddySoul(BuddyService service) {
        this.service = service;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    boolean canHeLive(Buddy buddy) {
        return buddy.isAlive() && buddy.getMood() > -100.0;
    }

    void rest(Buddy buddy) {
        service.update(
                new Buddy.BuddyBuilder()
                        .withId(buddy.getId())
                        .withMood(buddy.getMood())
                        .build());
    }
}
