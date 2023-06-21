package dol.buddy.addicted;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuddyRepository extends JpaRepository<Buddy, Long> {

    @Modifying
    @Query(value = "Update buddies b SET b.mood = ?2 WHERE b.id = ?1", nativeQuery = true)
    void update(Long id, double mood);

}
