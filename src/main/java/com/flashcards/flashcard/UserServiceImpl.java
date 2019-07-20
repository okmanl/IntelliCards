package com.flashcards.flashcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ErrorGenerator errorGenerator;

    public User getUser(String name, String p){return new User("e", "d" );}

    @Transactional 
    public User registerNewUser(UserDto newUser) throws RegistrationException{
 
        
        if( errorGenerator.errorExists( newUser ) ){
            throw new RegistrationException( errorGenerator.getError( newUser ) );
        }
        
 
        return new User( newUser.getEmail(), newUser.getPassword() );

    }
    public void updateUser(String email, User newUser){
 
    }

    // public void updateCard(long id, FlashCard newCard){ 
    //     repository.findById(id)
    //       .map(card -> {
    //         card.setStage(newCard.getStage()); 
    //         return repository.save(card);
    //       })
    //       .orElseGet(() -> {
    //         newCard.setId(id);
    //         return repository.save(newCard);
    //       });
    // }
  
    public void deleteUser(){}
}