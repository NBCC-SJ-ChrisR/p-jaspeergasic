package forjspr.PizzaApp.service;

import forjspr.PizzaApp.entities.Employee;
import forjspr.PizzaApp.entities.PizzaTopping;
import forjspr.PizzaApp.repository.EmployeeRepo;
import forjspr.PizzaApp.repository.PizzaToppingRepo;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author forjspr
 */
@Service
public class PizzaToppingService {

    @Autowired
    private PizzaToppingRepo ptRepo;
    private EmployeeRepo empRepo;

    //GET ALL
    public List<PizzaTopping> getToppings() {
        return ptRepo.findAll();
    }

    //GET IND
    public PizzaTopping getTopping(Integer id) {
        return ptRepo.findById(id).get();
    }
    
    //GET
    public List<PizzaTopping> getActive(){
        return ptRepo.findByisActive((byte)1);
    }

    //POST
    public PizzaTopping addTopping(PizzaTopping topping) {
//        Employee emp = empRepo.findById(topping.getEmpAddedBy().getId()).get();
//        topping.setEmpAddedBy(emp);
        topping.setCreatedDate(Instant.now());
        return ptRepo.save(topping);
    }

    //PUT
    public PizzaTopping updateTopping(PizzaTopping topping) {
        PizzaTopping tp = ptRepo.findById(topping.getId()).get();

        tp.setName(topping.getName());
        tp.setPrice(topping.getPrice());
        tp.setIsActive(topping.getIsActive());

        return ptRepo.save(tp);
    }

    //PUT
    public PizzaTopping setAvailability(PizzaTopping tp) {
        PizzaTopping topping = ptRepo.findById(tp.getId()).get();
        //disables when active, enables when inactive
        if (topping.getIsActive() == (byte) 1) {
            topping.setIsActive((byte) 0);
        } else {
            topping.setIsActive((byte) 1);
        }

        return ptRepo.save(topping);
    }

    //DELETE
    public void deleteTopping(Integer id) {
        ptRepo.deleteById(id);
    }

}
