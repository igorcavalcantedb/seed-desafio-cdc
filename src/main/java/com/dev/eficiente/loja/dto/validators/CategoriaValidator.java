package com.dev.eficiente.loja.dto.validators;

import com.dev.eficiente.loja.dto.CategoryDTO;
import com.dev.eficiente.loja.repository.CategoriaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoriaValidator implements Validator {

    private final CategoriaRepository categoriaRepository;

    public CategoriaValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoryDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        CategoryDTO categoryDTO = (CategoryDTO) target;
        var optionalCategoria = categoriaRepository.findByName(categoryDTO.getName());
        if (!optionalCategoria.isEmpty()) {
            errors.rejectValue("name", "402", "Nome já existente");
        }

    }
}
