import card.Card;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author christianguantiva
 */
public interface CardRepository extends JpaRepository<Card, UUID>{
    boolean existsByCardNumber(String cardNumber);
}
