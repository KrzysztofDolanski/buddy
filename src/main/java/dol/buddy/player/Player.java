package dol.buddy.player;

import dol.buddy.addicted.Buddy;
import dol.buddy.game.Game;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "player")
public final class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int points;
    private int road;
    @OneToMany
    private List<Buddy> buddies;
    @OneToOne
    private Game game;
}
