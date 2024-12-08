package forjspr.PizzaApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

/**
 *
 * @author forjspr
 */
@Entity
@Table(name = "pizzaTopping")
public class PizzaTopping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizzaTopping_id")
    private Integer id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal price;

    @Column(name="createdate", nullable = false)
    private Instant createdDate;

    @ManyToOne
    @JoinColumn(name="empAddedBy", nullable = false)
    private Employee empAddedBy;

    @Column(nullable = false)
    private Byte isActive;

    public PizzaTopping() {
    }

    public PizzaTopping(Integer id, String name, BigDecimal price, Instant createdDate, Employee empAddedBy, Byte isActive) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdDate = createdDate;
        this.empAddedBy = empAddedBy;
        this.isActive = isActive;
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

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Employee getEmpAddedBy() {
        return empAddedBy;
    }

    public void setEmpAddedBy(Employee empAddedBy) {
        this.empAddedBy = empAddedBy;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
    
    
    
    
}
