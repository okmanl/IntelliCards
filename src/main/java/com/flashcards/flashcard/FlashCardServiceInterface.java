package com.flashcards.flashcard;

import java.util.List;

interface FlashCardServiceInterface {
    void updateCard(long id, FlashCard newCard);
    FlashCard getCard(long id);
    List<FlashCard> getAllCards();
    void createCard(FlashCard newCard);
}