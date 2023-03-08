package com.dev.eficiente.loja.dto;

import com.dev.eficiente.loja.entity.Categoria;

public class CategoriaDTO {

    private final String name;
    private final String description;



    public CategoriaDTO(String name, String descricao) {
        this.name = name;
        this.description = descricao;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Categoria toDomain(){
        if(this.description.isBlank()){
            return new Categoria(this.getName());
        }
        return new Categoria(this.getName(),this.description);
    }
}
