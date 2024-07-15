package dol.buddy.addicted;

import dol.buddy.People;
import dol.buddy.player.PlayerController;
import dol.buddy.player.PlayerRepository;
import dol.buddy.world.WorldService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BuddyService {

    private final BuddyRepository buddyRepository;
    private final PlayerRepository playerRepository;
    private final WorldService worldService;
    private final double DAY = 1;

    public List<Buddy> getAllBuddies() {
        return buddyRepository.findAll();
    }

    protected void update(Buddy buddy) {
        buddyRepository.updateMood(buddy.getId(), buddy.getMood());
    }

    public void save(Buddy buddy) {
        buddyRepository.save(buddy);
    }

    void oneTurnOfLife(Buddy buddy){
        int road = playerRepository.getLastRoad(buddy.getPlayer().getId());
        double mood;

        switch (road) {
            case 1 -> {
                mood = worldService.changeMood(buddy);
            }
        }
        double age = buddy.getAge() + DAY;
    }

    Optional<List<Buddy>> getBuddyByName(String name){
        List<Buddy> byName = buddyRepository.findByName(name);
        return Optional.ofNullable(byName);
    }
}
