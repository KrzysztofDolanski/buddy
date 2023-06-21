package dol.buddy.addicted;

public class BuddySoul {

    private BuddyService service;

    boolean canHeLive(Buddy buddy) {
        return buddy.alive() && buddy.mood() > -100.0;
    }

    void rest(Buddy buddy) {
        service.update(
        Buddy.builder()
                .id(buddy.id())
                .name(buddy.name())
                .age(buddy.age())
                .mood(buddy.mood())
                .alive(buddy.alive())
                .money(buddy.money())
                .build()
        );
    }
}
