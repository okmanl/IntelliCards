package com.flashcards.flashcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements CommandLineRunner {

	
	private final FlashCardRepository flashcardRepository;
	private final UserRepository userRepository;

	@Autowired
	public LoadDatabase(FlashCardRepository flashcardRepository, UserRepository userRepository) {
		this.flashcardRepository = flashcardRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
 
        this.flashcardRepository.save(new FlashCard("What is JPA?"));
        
		this.flashcardRepository.save(new FlashCard("What is Spring Boot?", "A framework that allows writing web apps"));
		
		this.userRepository.save(new User("user", "password", "password"));
        
	}
}