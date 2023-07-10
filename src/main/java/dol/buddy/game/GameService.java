package dol.buddy.game;

import dol.buddy.player.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GameService {

    public Game createGame(Player player) {
        return Game.builder()
                .gameId(UUID.randomUUID().hashCode())
                .status(GameStatus.NEW)
                .build();
    }
}
