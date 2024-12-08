package forjspr.PizzaApp.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

/**
 *
 * @author forjspr
 */

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal subTotal;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal hst;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal orderTotal;

    @Column(nullable = false)
    private String orderStatus;

    @Column(nullable = false)
    private int delivery;

    @Column(nullable = false)
    private Instant deliveryDate;

    @Column(nullable = false)
    private Instant orderPlacedDate;

    public Order() {
    }

    public Order(Customer customer, BigDecimal subTotal, BigDecimal hst, BigDecimal orderTotal, String orderStatus, int delivery, Instant deliveryDate, Instant orderPlacedDate) {
        this.customer = customer;
        this.subTotal = subTotal;
        this.hst = hst;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.delivery = delivery;
        this.deliveryDate = deliveryDate;
        this.orderPlacedDate = orderPlacedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getHst() {
        return hst;
    }

    public void setHst(BigDecimal hst) {
        this.hst = hst;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public Instant getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Instant deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Instant getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public void setOrderPlacedDate(Instant orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
    }
    
    

}
