package com.flashcards.flashcard;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Email;

public class EmailValidator implements ConstraintValidator<Email, String>{
 
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {


        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return value.matches(regex); 
    }

}