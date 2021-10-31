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

                .antMatchers(HttpMethod.POST, "/addusertodatabase").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/addusertodatabase").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/updatemealplan").authenticated() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/updatemealplan").authenticated() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/addfoodtomealplan").authenticated()  // allowed by anyone
                .antMatchers(HttpMethod.GET, "/addfoodtomealplan").authenticated()  // allowed by anyone
                .antMatchers(HttpMethod.GET, "/getenergyhistory").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/getenergyhistory").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/getweighthistory").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/getweighthistory").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/getwaterhistory").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/getwaterhistory").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/get-avg-macronutrients-for-period").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/get-avg-macronutrients-for-period").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/get-avg-nutrients-for-period").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/get-avg-nutrients-for-period").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/signin").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/signin").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/getuserdata").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/getuserdata").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/search/{searchWord}").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/search/{searchWord}").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/changeamountoffood").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/changeamountoffood").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/deletefood").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/deletefood").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/changeamountoffoodtocustomvalue").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/changeamountoffoodtocustomvalue").permitAll() // allowed by anyone
//                .antMatchers(HttpMethod.GET, "http://localhost:3000/nutrition-details").permitAll() // allowed only when signed in
//                .antMatchers(HttpMethod.POST, "http://localhost:3000/nutrition-details").permitAll() // allowed only when signed in
//                .antMatchers(HttpMethod.DELETE, "/vehicles/**").hasRole("ADMIN") // allowed if signed in with ADMIN role
                .antMatchers(HttpMethod.GET, "/select-custom-nutrient").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/select-custom-nutrient").permitAll() // allowed by anyone
                .anyRequest().denyAll() // anything else is denied
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenServices),
                        UsernamePasswordAuthenticationFilter.class);
    }
}