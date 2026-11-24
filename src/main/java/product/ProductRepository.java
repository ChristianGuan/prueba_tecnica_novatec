/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package product;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author christianguantiva
 */
public interface ProductRepository extends JpaRepository<Product, String>{
    
}
