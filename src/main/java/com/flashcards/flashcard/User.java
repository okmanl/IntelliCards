package com.flashcards.flashcard;

import lombok.Data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id; 
import javax.persistence.OneToMany;

@Data
@Entity

class User{
    private @Id @GeneratedValue long id;
    private String userName;
    private String password;
    private String passwordConfirm;
    private String role;
    @OneToMany
    private List<FlashCard> flashCards;
 
    User(String user, String pass, String passwordConfirm){
        this.userName = user;
        this.password = pass;
        this.passwordConfirm = passwordConfirm;
        this.role = "USER";
    }

    void appendCard(FlashCard card){
        flashCards.add(card);
    }



}