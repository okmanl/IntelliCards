package com.flashcards.flashcard;

 
import org.springframework.data.jpa.repository.JpaRepository; 

interface FlashCardRepository extends JpaRepository<FlashCard, Long> {

}