package com.dev.eficiente.loja.dto;

import com.dev.eficiente.loja.entity.Book;
import com.dev.eficiente.loja.util.NullPropertySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

@JsonSerialize(using = NullPropertySerializer.class)
public class ResponseBook {
    private String id;
    private String title;
    private String resume;
    private BigDecimal price;
    private int pages;
    private String isbn;
    private String release;
    private String category;
    private String autor;

    public ResponseBook(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public ResponseBook(String id, String title, String resume, BigDecimal price, int pages, String isbn, String release, String category, String autor) {
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.release = release;
        this.category = category;
        this.autor = autor;
    }

    public String getId() {
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

    public String getRelease() {
        return release;
    }

    public String getCategory() {
        return category;
    }

    public String getAutor() {
        return autor;
    }

    public static ResponseBook fromDomain(Book book) {
        return new ResponseBook(null, book.getTitle(),
                book.getResume(),
                book.getPrice(),
                book.getPages(),
                book.getIsbn(),
                book.getRelease().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                book.getCategory().getName(),
                book.getAutor().getName());


    }
}
