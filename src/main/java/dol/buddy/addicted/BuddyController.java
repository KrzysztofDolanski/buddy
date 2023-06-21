package dol.buddy.addicted;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BuddyController {

    private final BuddyService service;

    @PostMapping(value = "/rest")
    void update(@RequestBody Buddy buddy) {
        service.update(buddy);
    }

    @PostMapping(value = "/save")
    void saveBuddy(@RequestBody Buddy buddy) {
        service.save(buddy);
    }


}
