
package forjspr.PizzaApp.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @author forjspr
 */
@Entity
@Table(name="pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pizza_id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name="pizzaSize_id")
    private PizzaSize size;
    
    @ManyToOne
    @JoinColumn(name="pizzaCrust_id")
    private PizzaCrust crust;
    
    @Column(nullable = false)
    private Integer quantity;
    
    @Column(nullable = false)
    private BigDecimal priceEach;
    
    @Column(nullable = false)
    private BigDecimal totalPrice;

    public Pizza() {
    }

    public Pizza(Integer id, Order order, PizzaSize size, PizzaCrust crust, Integer quantity, BigDecimal priceEach, BigDecimal totalPrice) {
        this.id = id;
        this.order = order;
        this.size = size;
        this.crust = crust;
        this.quantity = quantity;
        this.priceEach = priceEach;
        this.totalPrice = totalPrice;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public PizzaCrust getCrust() {
        return crust;
    }

    public void setCrust(PizzaCrust crust) {
        this.crust = crust;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
