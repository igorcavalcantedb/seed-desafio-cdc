package com.dev.eficiente.loja.endpoints;

import com.dev.eficiente.loja.dto.AutorDTO;
import com.dev.eficiente.loja.mappers.AutorMapper;
import com.dev.eficiente.loja.repository.AutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/v1/autor")
public class AutorResource {
    private final AutorRepository autorRepository;

    public AutorResource(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorDTO> saveAutor(@Valid @RequestBody AutorDTO autorDTO){

        var autor = autorRepository.save(AutorMapper.toDomain(autorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(AutorMapper.fromDomain(autor));
    }
}
