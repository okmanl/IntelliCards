package com.flashcards.flashcard.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Override 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 


        auth.inMemoryAuthentication().withUser("user").password( passwordEncoder().encode("password") ).roles("USER");
  
        auth.userDetailsService(userDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/login","/logout", "/registration", "/showViewPage").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").permitAll().and().logout().permitAll();

        
    } 


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}














// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private UserService userService;

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//                 .authorizeRequests()
//                     .antMatchers(
//                             "/registration",
//                             "/js/**",
//                             "/css/**",
//                             "/img/**",
//                             "/webjars/**").permitAll()
//                     .anyRequest().authenticated()
//                 .and()
//                     .formLogin()
//                         .loginPage("/login")
//                             .permitAll()
//                 .and()
//                     .logout()
//                         .invalidateHttpSession(true)
//                         .clearAuthentication(true)
//                         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                         .logoutSuccessUrl("/login?logout")
//                 .permitAll();
//     }

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder(){
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public DaoAuthenticationProvider authenticationProvider(){
//         DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//         auth.setUserDetailsService(userService);
//         auth.setPasswordEncoder(passwordEncoder());
//         return auth;
//     }

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.authenticationProvider(authenticationProvider());
//     }

// }