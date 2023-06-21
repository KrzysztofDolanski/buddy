package dol.buddy.addicted;

import dol.buddy.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * Buddy will have behaviour/mood that will generate his stage to be health or death.
 * He will make suicide if his mood will become too low.
 * World things can have impact on him.
 */
@Entity
@Builder
@Table(name = "buddy")
@AllArgsConstructor
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

    public Buddy() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public double age() {
        return age;
    }

    public double mood() {
        return mood;
    }

    public boolean alive() {
        return alive;
    }

    public double money() {
        return money;
    }

    @ManyToOne
    public Player player() {
        return player;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Buddy) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Double.doubleToLongBits(this.age) == Double.doubleToLongBits(that.age) &&
                Double.doubleToLongBits(this.mood) == Double.doubleToLongBits(that.mood) &&
                this.alive == that.alive &&
                Double.doubleToLongBits(this.money) == Double.doubleToLongBits(that.money) &&
                Objects.equals(this.player, that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, mood, alive, money, player);
    }

    @Override
    public String toString() {
        return "Buddy[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "age=" + age + ", " +
                "mood=" + mood + ", " +
                "alive=" + alive + ", " +
                "money=" + money + ", " +
                "player=" + player + ']';
    }


}
