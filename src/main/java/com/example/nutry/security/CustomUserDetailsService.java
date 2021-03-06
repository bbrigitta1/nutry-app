package com.example.nutry.security;

import com.example.nutry.repository.UserRepository;
import com.example.nutry.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserService users;

    public CustomUserDetailsService(UserService users) {
        this.users = users;
    }

    /**
     * Loads the user from the DB and converts it to Spring Security's internal User object.
     * Spring will call this code to retrieve a user upon login from the DB.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.example.nutry.model.User appUser = users.findUserByEmail(email);
//                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));

        return new User(appUser.getEmail(), appUser.getPassword(),
                appUser.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}