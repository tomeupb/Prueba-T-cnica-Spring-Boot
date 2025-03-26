package com.actividad.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request->

                request.requestMatchers("/api/naves").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/naves/").authenticated()
                        .requestMatchers(HttpMethod.DELETE,"/api/naves/{id}").authenticated()
                        .requestMatchers(HttpMethod.PUT,"/api/naves/").authenticated()
                )
                .httpBasic(Customizer.withDefaults())

                .csrf(csrf->csrf.disable());
   return http.getOrBuild();

    }

    @Bean
    public UserDetailsService testUser() {

        User.UserBuilder user = User.builder();

        UserDetails user1 = user.username("tomeu").
                password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        return  new InMemoryUserDetailsManager(user1);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    }







}
