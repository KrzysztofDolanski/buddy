package dol.buddy.addicted;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuddyRepository extends JpaRepository<Buddy, Long> {

    @Modifying
    @Query(value = "Update buddy b SET b.mood = ?2 WHERE b.id = ?1", nativeQuery = true)
    void updateMood(Long id, double mood);

    @Query(value = "Select * FROM buddy b WHERE b.name = ?1", nativeQuery = true)
    List<Buddy> findByName(String name);

}
