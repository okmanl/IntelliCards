package com.flashcards.flashcard.Web.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class UserDto { 
    @NotNull
    @NotEmpty
    private String email;
      
     
    @NotNull
    @NotEmpty
    private String password;  
     
    @NotNull
    @NotEmpty
    private String confirmPassword;  
      
}