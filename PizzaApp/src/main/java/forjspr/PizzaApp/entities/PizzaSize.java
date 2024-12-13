package forjspr.PizzaApp.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @author forjspr
 */
@Entity
@Table(name = "pizzasize")
public class PizzaSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizzaSize_id")
    private Integer id;

    @Column(nullable = false, length = 16)
    private String name;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal price;

    public PizzaSize() {
    }

    public PizzaSize(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
