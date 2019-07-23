package com.flashcards.flashcard.Service;

import java.util.Collection;

import com.flashcards.flashcard.Error.RegistrationException;
import com.flashcards.flashcard.Model.User;
import com.flashcards.flashcard.Repository.UserRepository;
import com.flashcards.flashcard.Web.Dto.UserDto;
import com.flashcards.flashcard.Error.ErrorGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

@Service
class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository repository;

    @Autowired
    private ErrorGenerator errorGenerator;
    private static final long serialVersionUID = 4650651158090188271L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    // eric implemented methods
    @Override
    public User getUser(String name, String password) {
        return null;
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void updateUser(String email, User user) {

    }

    @Transactional
    @Override
    public User registerNewUser(UserDto userDto) {
        if (errorGenerator.errorExists(userDto)) {
            throw new RegistrationException(errorGenerator.getError(userDto));
        }
    
        repository.save(new User(userDto.getEmail(), userDto.getPassword()));
        return new User(userDto.getEmail(), userDto.getPassword());
    }


 
 
}



// public User getUser(String name, String p) {
//     return new User("e", "d");
// }
 
// public void updateUser(String email, User newUser) {

// }

// public void updateCard(long id, FlashCard newCard){
// repository.findById(id)
// .map(card -> {
// card.setStage(newCard.getStage());
// return repository.save(card);
// })
// .orElseGet(() -> {
// newCard.setId(id);
// return repository.save(newCard);
// });
// }

// public void deleteUser() {
// }