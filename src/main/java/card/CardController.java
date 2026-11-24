package card;

import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CardResponse> issue(
            @Valid @RequestBody IssueCardRequest request) {

        return ResponseEntity.status(201).body(service.issue(request));
    }
    
    @GetMapping("/{cardId}")
    public ResponseEntity<CardResponse> get(@PathVariable("cardId") UUID cardID){
        return ResponseEntity.ok(service.get(cardID));
    }
    
    @PostMapping("/{cardId}/activate")
    public ResponseEntity<CardResponse> activate(@PathVariable("cardId") UUID cardId){
        return ResponseEntity.ok(service.activate(cardId));
    }
}