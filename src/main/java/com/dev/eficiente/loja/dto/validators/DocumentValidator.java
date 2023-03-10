package com.dev.eficiente.loja.dto.validators;

import com.dev.eficiente.loja.util.CpfCnpjValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentValidator implements ConstraintValidator<Document, Object> {
    @Override
    public void initialize(Document constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        var doc = (String) value;

        // Verifica se o valor é um CPF válido
        if (CpfCnpjValidator.isCPF(doc)) {
            return true;
        }

        // Verifica se o valor é um CNPJ válido
        if (CpfCnpjValidator.isCNPJ(doc)) {
            return true;
        }

        // Se chegou aqui, significa que o valor não é um CPF nem CNPJ válido
        return false;
    }
}
