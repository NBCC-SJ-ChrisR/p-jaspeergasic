
package forjspr.PizzaApp.service;

import forjspr.PizzaApp.entities.PizzaCrust;
import forjspr.PizzaApp.repository.PizzaCrustRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author forjspr
 */
@Service
public class PizzaCrustService {
    
    @Autowired
    private PizzaCrustRepo pcRepo;
    
    public List<PizzaCrust> getAll(){
        return pcRepo.findAll();
    }
    
    public PizzaCrust getById(Integer id){
        return pcRepo.findById(id).get();
    }
}
