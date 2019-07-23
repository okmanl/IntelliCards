package com.flashcards.flashcard.Repository;

 
import org.springframework.data.jpa.repository.JpaRepository; 
import com.flashcards.flashcard.Model.*;

public interface UserRepository extends JpaRepository<User, Long> {

    // assuming this works
    User findByEmail(String email);
}