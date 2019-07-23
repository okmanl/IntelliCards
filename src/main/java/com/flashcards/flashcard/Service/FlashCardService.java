package com.flashcards.flashcard.Service;

import java.util.List;

import com.flashcards.flashcard.Model.FlashCard;

public interface FlashCardService {
    void updateCard(long id, FlashCard newCard);
    FlashCard getCard(long id);
    List<FlashCard> getAllCards();
    void createCard(FlashCard newCard);
}