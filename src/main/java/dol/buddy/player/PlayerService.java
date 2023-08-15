package dol.buddy.player;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public ResponseEntity createPlayer(String playerName) {
        Player player = Player.builder().name(playerName).build();
        List<Player> players = playerRepository.getPlayerByName(playerName);
        if (players.size() < 1) {
            playerRepository.save(player);
            return ResponseEntity.status(HttpStatus.CREATED).body(Optional.of(player));
        } else {
            return ResponseEntity.badRequest().body(String.format("Player %s already exists", player.getName()));
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
