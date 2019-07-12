package com.flashcards.flashcard;
 
import java.net.URISyntaxException; 
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class FlashCardController {  
    private final FlashCardService fcs;

    FlashCardController(FlashCardService fcs) {
        this.fcs = fcs; 
    } 

    @CrossOrigin(origins = "http://localhost:3000") 
    @GetMapping(value = "/flashcards", produces = "application/json; charset=UTF-8")
    ResponseEntity<Object> all() { 
      return new ResponseEntity<>( fcs.getAllCards(), HttpStatus.OK); 
    }

    @CrossOrigin(origins = "http://localhost:3000") 
    @GetMapping(value = "/flashcards/{id}")
    ResponseEntity<FlashCard> one(@PathVariable long id) { 
      return new ResponseEntity<>( fcs.getCard(id), HttpStatus.OK); 
    }
    
    @CrossOrigin(origins = "http://localhost:3000") 
    @PostMapping(value = "/flashcards", produces = "application/json; charset=UTF-8")
    ResponseEntity<?> newCard(@RequestBody FlashCard newCard) throws URISyntaxException { 
      fcs.createCard( newCard );
      return new ResponseEntity<>( "Card created", HttpStatus.OK ); 
    } 

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/flashcards/{id}", produces = "application/json; charset=UTF-8")
    ResponseEntity<?> updateCard(@RequestBody FlashCard newCard, @PathVariable Long id) throws URISyntaxException {    
      fcs.updateCard(id, newCard);
      return new ResponseEntity<>("Card updated", HttpStatus.OK);
    }


}