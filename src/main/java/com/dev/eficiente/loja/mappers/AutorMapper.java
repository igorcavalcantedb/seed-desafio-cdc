package com.dev.eficiente.loja.mappers;

import com.dev.eficiente.loja.dto.AutorDTO;
import com.dev.eficiente.loja.entity.Autor;

public class AutorMapper {

    private AutorMapper() {

    }

    public static Autor toDomain(AutorDTO dto) {
        return new Autor(dto.getName(), dto.getEmail(), dto.getDescription());

    }

    public static AutorDTO fromDomain(Autor autor) {
        return new AutorDTO(autor.getName(), autor.getEmail(), autor.getDescription());
    }
}
