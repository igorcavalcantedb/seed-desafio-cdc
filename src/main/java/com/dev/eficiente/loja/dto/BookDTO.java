package com.dev.eficiente.loja.dto;

import com.dev.eficiente.loja.dto.validators.ExistsId;
import com.dev.eficiente.loja.dto.validators.UniqueValue;
import com.dev.eficiente.loja.entity.Autor;
import com.dev.eficiente.loja.entity.Book;
import com.dev.eficiente.loja.entity.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDTO {
    @NotBlank
    @UniqueValue(domainClass = Book.class, message = "Título já existe", fieldName = "title")
    private final String title;
    @NotBlank
    @Size(max = 500)
    private final String resume;
    @NotNull
    @Min(value = 20)
    private final BigDecimal price;
    @Min(100)
    private final int pages;
    @NotBlank
    private final String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate release;
    @NotNull
    @ExistsId(domainClass = Category.class, fieldName = "id")
    private final Long categoryId;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private final Long autorId;

    public BookDTO(String title, String resume, BigDecimal price, int pages, String isbn, LocalDate release, Long categoryId, Long autorId) {
        this.title = title;
        this.resume = resume;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.release = release;
        this.categoryId = categoryId;
        this.autorId = autorId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getAutorId() {
        return autorId;
    }

    //Setter necessário para o Jakson funcionar
    public void setRelease(LocalDate localDate){
        this.release = localDate;
    }

    public  Book toDomain() {
        return new Book(title, resume, price, pages, isbn, release, new Category(categoryId), new Autor(autorId));
    }


}
