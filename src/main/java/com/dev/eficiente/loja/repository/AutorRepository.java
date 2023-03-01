package com.dev.eficiente.loja.repository;

import com.dev.eficiente.loja.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}
