/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package product;

import jakarta.persistence.*;

/**
 *
 * @author christianguantiva
 */
@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @Column (length = 6)
    private String productId;
    
    @Column (nullable = false)
    private String name;
    
    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private ProductType type;
    
    protected Product(){
    }
    
    public Product(String productId, String name, ProductType type){
        this.productId = productId;
        this.name = name;
        this.type = type;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }
    
}
