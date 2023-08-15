package dol.buddy.time;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public final class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    @OneToMany
    List<Eventums> eventsList;

    public EventEntity(String type, Map<String, String> data) {
        this.type = type;
        this.eventsList = new ArrayList<>();
        for (String key : data.keySet()) {
            eventsList.add(new Eventums(key, data.get(key)));
        }
    }
}
