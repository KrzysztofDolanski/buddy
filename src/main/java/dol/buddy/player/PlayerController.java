package dol.buddy.player;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class PlayerController {

    private final PlayerService playerService;


    @GetMapping(value = "/{playerName}")
    public void createPlayer(@PathVariable ("playerName") String playerName) {
        playerService.createPlayer(playerName);
    }

}
