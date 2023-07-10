package dol.buddy.game;

import dol.buddy.player.Player;
import dol.buddy.player.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class GameController {

    private final GameService service;
    private final PlayerService playerService;

    @PostMapping("/addplayer")
    public void addPlayer(@ModelAttribute Player player) {
        playerService.createPlayer(player.getName());
    }

}
