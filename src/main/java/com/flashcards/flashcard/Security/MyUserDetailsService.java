package com.flashcards.flashcard.Security;

import java.util.ArrayList;
import java.util.List;

import com.flashcards.flashcard.Model.User;
import com.flashcards.flashcard.Repository.*;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; 

    @Autowired
    AuthenticationManagerBuilder auth;

    public void saveNewUser(User user) {

        UserDetails newUser = loadUserByUsername(user.getEmail());

        // userDetailsManager.createUser(newUser);

        log.info("-----------------SAVE NEW USER CALLED---------------------");
        org.springframework.security.core.Authentication authentication = new UsernamePasswordAuthenticationToken(
                newUser, null, newUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication); 

        try {

            log.info("------------------IN MEMORY AUTH SUCCESSFUL-----------------");
            log.info(user.getEmail() + user.getPassword() );
            auth.inMemoryAuthentication().withUser( user.getEmail() ).password(new BCryptPasswordEncoder().encode( user.getPassword() ))
                    .roles("USER");
        } catch (Exception e) { 
            log.info("--------------------NOPE----------------");
            e.printStackTrace();
        }
     
    }
 


    public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
  
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(
              "No user found with username: "+ email);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true; 
        return  new org.springframework.security.core.userdetails.User
          (
              user.getEmail(), 
              user.getPassword().toLowerCase(), enabled, accountNonExpired, 
              credentialsNonExpired, accountNonLocked, 
              getAuthorities(user.getRole())
              );
    }
     
    private static List<GrantedAuthority> getAuthorities (String role) {
        List<GrantedAuthority> authorities = new ArrayList<>(); 

        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}





// BELOW IS SOLUTION TO ALL PROBLEMS

// public class AuthenticationExample {
//     private static AuthenticationManager am = new SampleAuthenticationManager();
    
//     public static void main(String[] args) throws Exception {
//         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
//         while(true) {
//         System.out.println("Please enter your username:");
//         String name = in.readLine();
//         System.out.println("Please enter your password:");
//         String password = in.readLine();
//         try {
//             Authentication request = new UsernamePasswordAuthenticationToken(name, password);
//             Authentication result = am.authenticate(request);
//             SecurityContextHolder.getContext().setAuthentication(result);
//             break;
//         } catch(AuthenticationException e) {
//             System.out.println("Authentication failed: " + e.getMessage());
//         }
//         }
//         System.out.println("Successfully authenticated. Security context contains: " +
//                 SecurityContextHolder.getContext().getAuthentication());
//     }
//     }
    
// class SampleAuthenticationManager implements AuthenticationManager {
//     static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
    
//     static {
//         AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
//     }
    
//     public Authentication authenticate(Authentication auth) throws AuthenticationException {
//         if (auth.getName().equals(auth.getCredentials())) {
//         return new UsernamePasswordAuthenticationToken(auth.getName(),
//             auth.getCredentials(), AUTHORITIES);
//         }
//         throw new BadCredentialsException("Bad Credentials");
//     }
//     }