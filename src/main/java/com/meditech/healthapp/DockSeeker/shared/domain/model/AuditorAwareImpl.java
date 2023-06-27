package com.meditech.healthapp.DockSeeker.shared.domain.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware {
    @Override
    public @NotNull Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}
