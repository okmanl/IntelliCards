package com.flashcards.flashcard.Service;

import com.flashcards.flashcard.Model.User;
import com.flashcards.flashcard.Web.Dto.UserDto;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService extends UserDetails {
    User getUser(String name, String password);
    void deleteUser();
    void updateUser(String email, User user);
    User registerNewUser(UserDto userDto);

}