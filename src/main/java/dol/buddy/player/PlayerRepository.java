package dol.buddy.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> getPlayerByName(String playerName);

    @Query(value = "SELECT road FROM players p WHERE p.id = ?1", nativeQuery = true)
    int getLastRoad(Long playerId);

}
