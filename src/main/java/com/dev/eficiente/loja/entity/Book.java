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
    @Future
    private LocalDate release;
    @NotNull
    @ManyToOne
    private Category category;
    @NotNull
    @ManyToOne
    private Autor autor;
    @Deprecated
    public Book() {}

    public Book(String title, String resume, BigDecimal price, int pages, String isbn, LocalDate release, Category category, Autor autor) {
        this.title = title;
        this.resume = resume;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.release = release;
        this.category = category;
        this.autor = autor;
    }

    public Book(String title, String resume, BigDecimal price, int pages, String isbn, Category category, Autor autor) {
        new Book(title, resume, price, pages, isbn,null, category,autor);
    }

    public Long getId() {
        return id;
    }



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

    public Category getCategory() {
        return category;
    }

    public Autor getAutor() {
        return autor;
    }
}
