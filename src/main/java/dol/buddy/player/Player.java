package dol.buddy.player;

import dol.buddy.addicted.Buddy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;


@Entity
@Builder
@AllArgsConstructor
public final class Player {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int points;
    @OneToMany
    private List<Buddy> buddies;

    public Player() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public int points() {
        return points;
    }

    @OneToMany
    public List<Buddy> buddies() {
        return buddies;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Player) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                this.points == that.points &&
                Objects.equals(this.buddies, that.buddies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, points, buddies);
    }

    @Override
    public String toString() {
        return "Player[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "points=" + points + ", " +
                "buddies=" + buddies + ']';
    }

}
