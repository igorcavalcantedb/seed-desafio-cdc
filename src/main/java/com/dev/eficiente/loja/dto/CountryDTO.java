package com.dev.eficiente.loja.dto;

import com.dev.eficiente.loja.entity.Country;

public class CountryDTO {
    private String name;

    public CountryDTO() {
    }

    public CountryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Country toDomain(){
        return new Country(this.name);
    }
}
