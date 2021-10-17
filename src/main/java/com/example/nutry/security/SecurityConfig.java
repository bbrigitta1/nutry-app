package com.example.nutry.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenServices jwtTokenServices;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    public SecurityConfig(JwtTokenServices jwtTokenServices) {
        this.jwtTokenServices = jwtTokenServices;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll() // allowed by anyone

                .antMatchers(HttpMethod.POST, "/updatemealplan").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/updatemealplan").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/addfoodtomealplan").authenticated() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/addfoodtomealplan").authenticated() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/getenergyhistory").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/getenergyhistory").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/signin").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/signin").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/search/{searchWord}").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/search/{searchWord}").permitAll() // allowed by anyone

//                .antMatchers(HttpMethod.GET, "http://localhost:3000/nutrition-details").permitAll() // allowed only when signed in
//                .antMatchers(HttpMethod.POST, "http://localhost:3000/nutrition-details").permitAll() // allowed only when signed in
//                .antMatchers(HttpMethod.DELETE, "/vehicles/**").hasRole("ADMIN") // allowed if signed in with ADMIN role
                .anyRequest().denyAll() // anything else is denied
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenServices),
                        UsernamePasswordAuthenticationFilter.class);
    }
}