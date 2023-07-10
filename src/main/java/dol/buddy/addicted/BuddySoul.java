package dol.buddy.addicted;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BuddySoul {

    private BuddyService service;

    boolean canHeLive(Buddy buddy) {
        return buddy.isAlive() && buddy.getMood() > -100.0;
    }

    void rest(Buddy buddy) {
        service.update(
        Buddy.builder()
                .id(buddy.getId())
                .name(buddy.getName())
                .age(buddy.getAge())
                .mood(buddy.getMood())
                .alive(buddy.isAlive())
                .money(buddy.getMoney())
                .build()
        );
    }
}
