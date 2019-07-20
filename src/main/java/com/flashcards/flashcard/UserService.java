package com.flashcards.flashcard;


interface UserService {
    User getUser(String name, String password);
    void deleteUser();
    void updateUser(String email, User user);
    User registerNewUser(UserDto userDto);

}