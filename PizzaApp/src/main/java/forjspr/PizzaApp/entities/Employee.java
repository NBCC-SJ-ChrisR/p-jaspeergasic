package forjspr.PizzaApp.entities;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author forjspr
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(nullable = false, length = 45)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;


    public Employee() {
    }

    public Employee(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
