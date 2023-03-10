package com.dev.eficiente.loja.endpoints;

import com.dev.eficiente.loja.dto.CountryDTO;
import com.dev.eficiente.loja.repository.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/country")
public class CountryResource {
    private final CountryRepository countryRepository;

    public CountryResource(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public ResponseEntity<CountryDTO> save(@Valid @RequestBody CountryDTO countryDTO){
        countryRepository.save(countryDTO.toDomain());
        return ResponseEntity.ok().body(countryDTO);
    }
}
