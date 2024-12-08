/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package forjspr.PizzaApp.repository;

import forjspr.PizzaApp.entities.PizzaSize;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author forjspr
 */
public interface PizzaSizeRepo extends JpaRepository<PizzaSize, Integer> {

}
