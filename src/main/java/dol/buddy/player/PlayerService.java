package dol.buddy.player;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public void createPlayer(String playerName) {
        List<Player> players = playerRepository.getPlayerByName(playerName);
        if (players.size() < 1){
            Player player = Player.builder().name(playerName).build();
            playerRepository.save(player);
        }
    }
}
