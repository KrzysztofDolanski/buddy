package dol.buddy.addicted;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@RestController(value = "/buddy")
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
    List<Buddy> getBuddy(@PathVariable("name") String name){
        return service.getBuddyByName(name).orElseGet(List::of);
    }

}
