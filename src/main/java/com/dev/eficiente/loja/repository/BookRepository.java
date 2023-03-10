package com.dev.eficiente.loja.repository;

import com.dev.eficiente.loja.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
