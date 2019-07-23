package com.flashcards.flashcard.Model;

import lombok.Data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id; 
import javax.persistence.OneToMany;

@Data
@Entity

public class User{
    private @Id @GeneratedValue long id;
    private String email;
    private String password; 
    private String role;
    @OneToMany
    private List<FlashCard> flashCards;
 
    User(){ 
    }
    public User(String email, String pass ){
        this.email = email;
        this.password = pass; 
        this.role = "USER";
    }

    void appendCard(FlashCard card){
        flashCards.add(card);
    }



}