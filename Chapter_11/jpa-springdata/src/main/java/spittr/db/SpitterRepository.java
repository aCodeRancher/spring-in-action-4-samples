package spittr.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import spittr.domain.Spitter;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSweeper {
	  
	Spitter findByUsername(String username);
	
	List<Spitter> findByUsernameOrFullNameLike(String username, String fullName);

	@Query("Select s from Spitter s where s.email like '%habuma.com'")
	List<Spitter> findAllHabumaEmailSpitters();
}
