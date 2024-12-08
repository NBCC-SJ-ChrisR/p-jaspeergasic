package forjspr.PizzaApp.service;

import forjspr.PizzaApp.entities.PizzaSize;
import forjspr.PizzaApp.repository.PizzaSizeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author forjspr
 */
@Service
public class PizzaSizeService {

    @Autowired
    private PizzaSizeRepo psRepo;

    public List<PizzaSize> getSizes() {
        return psRepo.findAll();
    }

    public PizzaSize getSize(Integer id) {
        return psRepo.findById(id).get();
    }
}
