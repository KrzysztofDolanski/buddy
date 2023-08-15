package dol.buddy.player;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/road/{number}")
    public String pickBuddyRoad(@PathVariable("number") Integer number) {
        return String.valueOf(number);
    }

    @GetMapping("/getplayer/{playerName}")
    public List<Player> getPlayer(@PathVariable("playerName") String playerName) {
        return playerService.findByName(playerName);
    }

    @PostMapping(value = "{playerName}")
    public ResponseEntity createPlayer(@PathVariable("playerName") String playerName) {
        return playerService.createPlayer(playerName);
    }

    @PostMapping("/addplayer")
    public void addPlayer(@ModelAttribute Player player) {
        playerService.createPlayer(player.getName());
    }

    @GetMapping("/player")
    public ResponseEntity<Player> showFirstPlayer() {
        return ResponseEntity.of(playerService.findAll().stream().findFirst());
    }

}
