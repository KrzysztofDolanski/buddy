package dol.buddy.addicted;

import dol.buddy.People;
import dol.buddy.player.Player;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Buddy will have behaviour/mood that will generate his stage to be health or death.
 * He will make suicide if his mood will become too low.
 * World things can have impact on him.
 */
@Entity
@Data
@Table(name = "buddy")
public final class Buddy implements People, Serializable {

    private Buddy(BuddyBuilder buddyBuilder) {
        this.player = buddyBuilder.player;
        this.money = buddyBuilder.money;
        this.alive = buddyBuilder.alive;
        this.mood = buddyBuilder.mood;
        this.age = buddyBuilder.age;
        this.name = buddyBuilder.name;
        this.id = buddyBuilder.id;
    }

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

    public static class BuddyBuilder {
        private Long id;
        private String name;
        private double age;
        private double mood;
        private boolean alive;
        private double money;
        private Player player;

        public BuddyBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public BuddyBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public BuddyBuilder withAge(double age){
            this.age = age;
            return this;
        }
        public BuddyBuilder withMood(double mood){
            this.mood = mood;
            return this;
        }
        public BuddyBuilder withAlive(boolean alive){
            this.alive = alive;
            return this;
        }
        public BuddyBuilder withMoney(double money){
            this.money = money;
            return this;
        }
        public BuddyBuilder withPlayer(Player player){
            this.player = player;
            return this;
        }

        public Buddy build() {
            return new Buddy(this);
        }
    }
}
