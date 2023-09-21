package com.example.bookstore2.config;

import com.example.bookstore2.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
        .csrf(AbstractHttpConfigurer::disable)
        .formLogin(Customizer.withDefaults())
        .logout(Customizer.withDefaults())
        .sessionManagement(
            configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .httpBasic(Customizer.withDefaults())
        .authorizeHttpRequests(
            matcherRegistry ->
                matcherRegistry
                    .requestMatchers(
                        AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/authors/**"),
                        AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/genres/**"),
                        AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/books/**"),
                        AntPathRequestMatcher.antMatcher(HttpMethod.PUT, "/authors/**"),
                        AntPathRequestMatcher.antMatcher(HttpMethod.PUT, "/genres/**"),
                        AntPathRequestMatcher.antMatcher(HttpMethod.PUT, "/books/**"),
                        AntPathRequestMatcher.antMatcher(HttpMethod.DELETE, "/authors/**"),
                        AntPathRequestMatcher.antMatcher(HttpMethod.DELETE, "/genres/**"),
                        AntPathRequestMatcher.antMatcher(HttpMethod.DELETE, "/books/**")
                    )
                    .hasRole(Role.ADMIN.name())

                    .requestMatchers(HttpMethod.GET, "/authors/**", "/genres/**", "/books/**")
                    .hasAnyRole(Role.ADMIN.name(), Role.USER.name())

                    .requestMatchers("/**").permitAll()
        )
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
