package com.flashcards.flashcard;

public final class RegistrationException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public RegistrationException() {
        super();
    }

    public RegistrationException(String message, Throwable cause){
        super(message, cause);
    }
    public RegistrationException(String message){
        super(message);
    }
    public RegistrationException(Throwable cause){
        super(cause);
    }
}