package com.flashcards.flashcard;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
// import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
class UserController {
 
  UserService userService;


  public UserController(UserService userService){
    this.userService = userService;
  }

  @GetMapping(value = "/login")
  String login(Model model) {

    log.info("congrats big bro!");

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
      userService.registerNewUser(user);
      return new ModelAndView("viewPage");
    } catch (Exception e) { 
      mav.addObject("errorMessage", e.getMessage());
      return mav;
    }    
  } 
}