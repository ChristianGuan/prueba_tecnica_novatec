/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author christianguantiva
 */
public interface CardRepository extends JpaRepository<Card, UUID>{
    boolean existsByCardNumber(String cardNumber);
}
