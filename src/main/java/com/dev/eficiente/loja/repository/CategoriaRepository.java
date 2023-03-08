package com.dev.eficiente.loja.repository;

import com.dev.eficiente.loja.entity.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    List<Optional<Categoria>> findByName(String name);

}
