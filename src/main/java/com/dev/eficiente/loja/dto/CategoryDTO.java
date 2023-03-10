package com.dev.eficiente.loja.dto;

import com.dev.eficiente.loja.entity.Category;

public class CategoryDTO {

    private final String name;
    private final String description;



    public CategoryDTO(String name, String descricao) {
        this.name = name;
        this.description = descricao;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category toDomain(){
        if(this.description.isBlank()){
            return new Category(this.getName());
        }
        return new Category(this.getName(),this.description);
    }
}
