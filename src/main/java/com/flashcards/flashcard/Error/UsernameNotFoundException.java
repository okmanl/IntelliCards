package com.flashcards.flashcard.Error;
public class UsernameNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 5861310537366287163L;

    public UsernameNotFoundException(){
        super();
    }

    public UsernameNotFoundException(String message){
        super(message);
    }

}