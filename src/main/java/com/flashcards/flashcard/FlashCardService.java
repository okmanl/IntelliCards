package com.flashcards.flashcard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class FlashCardService implements FlashCardServiceInterface {

    @Autowired
    private FlashCardRepository repository; 
    public FlashCard getCard(long id){ 
        return repository.getOne(id);
    }
 
    public void updateCard(long id, FlashCard newCard){ 
        repository.findById(id)
          .map(card -> {
            card.setStage(newCard.getStage()); 
            return repository.save(card);
          })
          .orElseGet(() -> {
            newCard.setId(id);
            return repository.save(newCard);
          });
    }
  
    public List<FlashCard>  getAllCards(){ 
        return repository.findAll(); 
    }

    public void createCard(FlashCard newCard){ 
        repository.save(newCard);
    } 

}