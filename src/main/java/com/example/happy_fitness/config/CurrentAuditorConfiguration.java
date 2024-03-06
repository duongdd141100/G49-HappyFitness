package com.example.happy_fitness.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Configuration
public class CurrentAuditorConfiguration implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        try {
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return Optional.of(user.getUsername());
        } catch (Exception e) {
            return Optional.of("System");
        }
    }
}
