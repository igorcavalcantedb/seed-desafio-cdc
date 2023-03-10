package com.dev.eficiente.loja.endpoints;

import com.dev.eficiente.loja.dto.NoLoginPaymentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("v1/payment")
public class PaymentResource {

    @PostMapping
    public ResponseEntity<?> noLoginPayment(@Valid @RequestBody NoLoginPaymentDTO noLoginPaymentDTO){
        System.out.println(noLoginPaymentDTO.toString());
        return ResponseEntity.ok(noLoginPaymentDTO.toString());
    }
}
