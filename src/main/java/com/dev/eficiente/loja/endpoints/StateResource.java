package com.dev.eficiente.loja.endpoints;

import com.dev.eficiente.loja.dto.StateDTO;
import com.dev.eficiente.loja.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/state")
public class StateResource {
    private final StateRepository stateRepository;

    public StateResource(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @PostMapping
    public ResponseEntity<StateDTO> save(@Valid @RequestBody StateDTO stateDTO){
        stateRepository.save(stateDTO.toDomain());
        return ResponseEntity.ok().body(stateDTO);

    }
}
