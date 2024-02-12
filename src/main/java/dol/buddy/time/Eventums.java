package dol.buddy.time;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Eventums {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    EventEntity eventEntity;
    String event;
    String eventValue;

    public Eventums(String event, String eventValue) {
        this.event = event;
        this.eventValue = eventValue;
    }
}
