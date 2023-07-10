package dol.buddy.addicted;

import dol.buddy.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * Buddy will have behaviour/mood that will generate his stage to be health or death.
 * He will make suicide if his mood will become too low.
 * World things can have impact on him.
 */
@Entity
@Data
@Builder
@Table(name = "buddy")
@AllArgsConstructor
@RequiredArgsConstructor
public final class Buddy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double age;
    private double mood;
    private boolean alive;
    private double money;
    @ManyToOne
    private Player player;

}
