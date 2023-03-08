package com.dev.eficiente.loja.dto;

import com.dev.eficiente.loja.dto.validators.UniqueValue;
import com.dev.eficiente.loja.entity.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {
    @NotBlank
    @Size(max = 100)
    private final String name;
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private final String email;
    @Size(max = 400)
    private final String description;

    public AutorDTO(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
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
}
