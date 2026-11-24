/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.UUID;
import product.Product;

/**
 *
 * @author christianguantiva
 */

@Entity
@Table(name = "cards")
public class Card {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cardID;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    private String cardNumber;
    
    @Column (nullable = false, length = 120)
    private String holderName;
    
    @Column (nullable = false )
    private LocalDate issuedAt;
    
    @Column (nullable = false)
    private LocalDate expiresAt;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardStatus status;
    
    @Column (length = 255)
    private String blockedReason;
    
    @Column (nullable = false, precision = 19, scale = 2 )
    private BigDecimal balance;
    
    @Column (nullable = false, length = 3)
    private String currency;
    
    protected Card(){}
    
    public Card(Product product, String cardNumber, String holderName){
        this.product = product;
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.issuedAt = LocalDate.now(ZoneOffset.UTC);
        this.expiresAt = this.issuedAt.plusYears(3);
        this.status = CardStatus.ISSUED;
        this.balance = new BigDecimal("0.00");
        this.currency = "USD";
    }

    public UUID getCardID() {
        return cardID;
    }

    public void setCardID(UUID cardID) {
        this.cardID = cardID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public LocalDate getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDate issuedAt) {
        this.issuedAt = issuedAt;
    }

    public LocalDate getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDate expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public String getBlockedReason() {
        return blockedReason;
    }

    public void setBlockedReason(String blockedReason) {
        this.blockedReason = blockedReason;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    
    
    
    
}
