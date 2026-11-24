/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.security.SecureRandom;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import product.Product;
import product.ProductRepository;


/**
 *
 * @author christianguantiva
 */
@Service
public class CardService {
    private final CardRepository cards;    
    private final ProductRepository products;
    private final SecureRandom random = new SecureRandom();
    
    public CardService(CardRepository cards, ProductRepository products){
        this.cards = cards;
        this.products = products;
    }
    
    @Transactional
    public CardResponse issue(IssueCardRequest request){
        Product product = products.findById(request.productId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "producto no encontrado"));
        String number;
        
        do{
            StringBuilder generated = new StringBuilder(product.getProductId());
            for (int i=0; i<10; i++){
                generated.append(random.nextInt(10));
            }
            number = generated.toString();
        }while(cards.existsByCardNumber(number));
        
        Card card = new Card(product, number, request.holderName());
        Card saved = cards.save(card);
        
        return new CardResponse(
                saved.getCardID(),
                saved.getCardNumber(),
                saved.getStatus(),
                saved.getExpiresAt(),
                saved.getBalance(),
                saved.getCurrency()
        );
    
    }
}
