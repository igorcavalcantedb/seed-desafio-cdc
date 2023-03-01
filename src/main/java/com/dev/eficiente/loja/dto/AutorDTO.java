package com.dev.eficiente.loja.dto;

import java.time.LocalDateTime;

public class AutorDTO {
    private final String name;

    private final String email;

    private final String description;

    private final LocalDateTime createdAt;

    public AutorDTO(String name, String email, String description, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
