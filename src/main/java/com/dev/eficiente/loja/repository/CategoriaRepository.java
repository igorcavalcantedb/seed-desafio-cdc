package com.dev.eficiente.loja.repository;

import com.dev.eficiente.loja.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Category, Long> {
    List<Optional<Category>> findByName(String name);

}
