package dol.buddy.player;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public void createPlayer(String playerName) {
        List<Player> players = playerRepository.getPlayerByName(playerName);
        if (players.size() < 1) {
            Player player = Player.builder().name(playerName).build();
            playerRepository.save(player);
        }
    }

    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }


    public void delete(Player player) {
        playerRepository.delete(player);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public List<Player> findByName(String playerName) {
        return playerRepository.getPlayerByName(playerName);
    }
}
