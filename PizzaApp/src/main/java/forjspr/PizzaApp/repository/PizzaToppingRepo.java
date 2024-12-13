package forjspr.PizzaApp.repository;

import forjspr.PizzaApp.entities.PizzaTopping;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author forjspr
 */
public interface PizzaToppingRepo extends JpaRepository<PizzaTopping, Integer> {
     List<PizzaTopping> findByisActive(Byte isActive);
}
