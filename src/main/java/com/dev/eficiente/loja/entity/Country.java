package com.dev.eficiente.loja.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String name;

    @Deprecated
    public Country() {
    }

    public Country(Long id) {
        this.id = id;
    }

    public Country(String name) {
        this.name = name;
    }
}
