package dol.buddy.time;

import dol.buddy.People;
import dol.buddy.addicted.BuddyService;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Day implements Calendar {

    private final BuddyService buddyService;
    private final List<People> people;

    @Autowired
    public Day(BuddyService buddyService) {
        this.buddyService = buddyService;
        people = new ArrayList<>();
    }

    @Override
    public void start() {
        people.addAll(buddyService.getAllBuddies());
    }
}
