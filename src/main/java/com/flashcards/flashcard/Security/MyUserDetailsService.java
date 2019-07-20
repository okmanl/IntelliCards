package com.flashcards.flashcard.Security;

import java.util.ArrayList;
import java.util.List;

import com.flashcards.flashcard.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {
  
    @Autowired
    private UserRepository userRepository;
    // 
    public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
  
        com.flashcards.flashcard.User user = userRepository.findByEmail(email);
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
