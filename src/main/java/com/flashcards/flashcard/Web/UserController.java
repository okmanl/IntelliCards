package com.flashcards.flashcard.Web;

import javax.validation.Valid;

import com.flashcards.flashcard.Model.User;
import com.flashcards.flashcard.Security.MyUserDetailsService;
import com.flashcards.flashcard.Service.UserService;
import com.flashcards.flashcard.Web.Dto.UserDto;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;  
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Controller
class UserController {
 
  UserService userService;
  @Autowired
  AuthenticationManagerBuilder auth;
  @Autowired 
  MyUserDetailsService userDetailsService;

  public UserController(UserService userService){
    this.userService = userService;
  }

  @GetMapping(value = "/login")
  String login(Model model) {
 
    return "login";
  } 


  @GetMapping(value = "/showViewPage")
  public ModelAndView passParametersWithModel() {
    ModelAndView mav = new ModelAndView("viewPage.html");
    mav.addObject("message", "Baeldung");
    return mav;
  }

  @GetMapping(value = "/registration")
  public String showRegistrationForm(Model model) {
    return "registration";
  }

 
  @PostMapping(value = "/registration")
  public ModelAndView registerUserAccount( @ModelAttribute(value = "user")  @Valid UserDto user,
      BindingResult result ) {  

    ModelAndView mav = new ModelAndView(); 
    mav.setViewName("registration");

    if( result.hasErrors() ){ 
      mav.addObject("errorMessage", "Please fill out all fields");
      return mav;
    } 
    try {
      log.info("---------------regis complete ---------------");
      User newUser = userService.registerNewUser(user);

      userDetailsService.saveNewUser( newUser );
      log.info("---------------regis?????????????complete ---------------");
      return new ModelAndView("login");
    } catch (Exception e) { 
      mav.addObject("errorMessage", e.getMessage());
      return mav;
    }    
  }
  
  
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
}