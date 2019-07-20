package com.flashcards.flashcard;

 
import org.springframework.data.jpa.repository.JpaRepository; 

public interface UserRepository extends JpaRepository<User, Long> {

    // assuming this works
    User findByEmail(String email);
}