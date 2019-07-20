package com.flashcards.flashcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
class ErrorGenerator{

    @Autowired
    UserRepository repository;

    EmailValidator emailValidator;

    public ErrorGenerator(){
        this.emailValidator = new EmailValidator();
    }

    public String getError( UserDto user){ 
        if (emailExists( user.getEmail() )){ return "Username already exists!";}
        else if ( invalidEmail(user.getEmail() ) ){
            return "Invalid Email!";
        }
        else{ return "Passwords don't match!"; }
    }

    public boolean errorExists ( UserDto newUser ){
        return emailExists(newUser.getEmail()) || notMatchingPasswords( newUser ) || invalidEmail( newUser.getEmail() );
    }

    private boolean invalidEmail( String email ){
        return !this.emailValidator.isValid(email, null);
    }
    private boolean notMatchingPasswords( UserDto user ){
        return !user.getPassword().equals(user.getConfirmPassword());
    }

    private boolean emailExists(String email){
        User user = repository.findByEmail(email); 
        return user != null;

    }
}