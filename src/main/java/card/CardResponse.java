/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author christianguantiva
 */
public record CardResponse (
    UUID cardID,
    String cardNumber,
    CardStatus status,
    LocalDate expiresAt,
    BigDecimal balance,
    String currency  ) {
      
}
