package com.example.roomie.utils;

import com.example.roomie.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // todo: add checks if authentication is present and user is not null (i.e. signed in).

        User user = (User) authentication.getPrincipal();

        return Optional.of(user.getId());
    }

}
