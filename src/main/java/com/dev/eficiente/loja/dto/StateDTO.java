package com.dev.eficiente.loja.dto;

import com.dev.eficiente.loja.dto.validators.ExistsId;
import com.dev.eficiente.loja.entity.Country;
import com.dev.eficiente.loja.entity.State;

public class StateDTO {
    private final String name;
    @ExistsId(domainClass = Country.class, fieldName = "id")
    private final Long countryId;

    public StateDTO(String name, Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State toDomain(){
        return new State(this.name,new Country(countryId));
    }
}
