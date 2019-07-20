package com.flashcards.flashcard;

import lombok.Data;

import java.time.Duration;
import java.time.Instant; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class FlashCard{

    private @Id @GeneratedValue Long id;
    private String question;
    private String answer; 
    private int stage;

    private Instant dateLastAnswered;

    FlashCard(){
        this.dateLastAnswered = Instant.now();

    }

    FlashCard(String question, String answer){
        this.question = question;
        this.answer = answer;
        this.dateLastAnswered = Instant.now();
    }

    FlashCard(String question){
        this.question = question;
        this.dateLastAnswered = Instant.now();
    }


    public boolean isDue(){ 
        Duration d = Duration.between(this.dateLastAnswered, Instant.now()); 
        return d.toDays() >= this.stage*2; 
    }

    
}