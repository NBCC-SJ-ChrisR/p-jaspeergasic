
package forjspr.PizzaApp.entities;

import jakarta.persistence.*;

/**
 *
 * @author forjspr
 */
@Entity
@Table(name="pizzaTopping_map")
public class ToppingMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizzaTopping_map_id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="pizza_id")
    private Pizza pizza;
    
    @ManyToOne
    @JoinColumn(name="pizzaTopping_id")
    private PizzaTopping topping;

    public ToppingMap() {
    }

    public ToppingMap(Pizza pizza, PizzaTopping topping) {
        this.pizza = pizza;
        this.topping = topping;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public PizzaTopping getTopping() {
        return topping;
    }

    public void setTopping(PizzaTopping topping) {
        this.topping = topping;
    }
    
    
    
    
    
}
