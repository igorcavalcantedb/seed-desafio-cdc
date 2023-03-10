package com.dev.eficiente.loja.endpoints;

import com.dev.eficiente.loja.dto.CategoryDTO;
import com.dev.eficiente.loja.dto.validators.CategoriaValidator;
import com.dev.eficiente.loja.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/v1/category")
public class CategoriaResource {
    private final CategoriaRepository repository;
    private final CategoriaValidator categoriaValidator;

    public CategoriaResource(CategoriaRepository autorRepository, CategoriaValidator categoriaValidator) {
        this.repository = autorRepository;
        this.categoriaValidator = categoriaValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(categoriaValidator);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> saveCategory(@Valid @RequestBody CategoryDTO categoryDTO){

        repository.save(categoryDTO.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
    }
    @GetMapping
    public String getTest(){
        return "Test";
    }
}
