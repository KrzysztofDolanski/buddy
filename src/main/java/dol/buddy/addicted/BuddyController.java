package dol.buddy.addicted;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController(value = "")
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

    @GetMapping(value = "/{name}")
    String getBuddy(@PathVariable("name") String name){
        return service.getBuddyByName(name).get(0).getName();
    }
}
