package com.dev.eficiente.loja.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String title;
    @NotBlank
    @Size(max = 500)
    private String resume;
    @NotNull
    private BigDecimal price;
    private int pages;
    @NotBlank
    private String isbn;
    @NotNull
    @Future
    private LocalDate release;
    @NotNull
    private Categoria categoria;
    @NotNull
    private Autor autor;

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getRelease() {
        return release;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
