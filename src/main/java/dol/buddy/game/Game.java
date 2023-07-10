package dol.buddy.game;

import dol.buddy.player.Player;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Builder
@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    private Integer gameId;
    private GameStatus status;
    @OneToOne
    private Player player;
}
