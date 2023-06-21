package dol.buddy.addicted;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuddyService {

    private final BuddyRepository repository;

    protected void update(Buddy buddy) {
        repository.update(buddy.id(), buddy.mood());
    }

    public void save(Buddy buddy) {
        repository.save(buddy);
    }
}
