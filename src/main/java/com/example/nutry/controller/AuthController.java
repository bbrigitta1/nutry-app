package com.example.nutry.controller;

import com.example.nutry.model.UserCredentials;
import com.example.nutry.repository.UserRepository;
import com.example.nutry.security.JwtTokenServices;
import com.example.nutry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.LongToIntFunction;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="${crossorigin}")
public class AuthController {

    @Autowired
    UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices, UserRepository users) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody UserCredentials data, HttpServletRequest request) {
        try {
            String email = data.getEmail();
            // authenticationManager.authenticate calls loadUserByUsername in CustomUserDetailsService
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, data.getPassword()));

            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(email, roles);
            HttpSession session = request.getSession();
            System.out.println(userService.findUserByEmail(data.getEmail()).getId().getClass().getTypeName()); //Long
            System.out.println(userService.findUserByEmail(data.getEmail()).getId().toString()); // 1 (user id)
            session.setAttribute("id", userService.findUserByEmail(data.getEmail()).getId().toString());
            System.out.println("session id" + session.getAttribute("id")); // id in session
            System.out.println("id "+session.getId()); // session id

            Map<Object, Object> model = new HashMap<>();
            model.put("username", email);
            model.put("roles", roles);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }
}
