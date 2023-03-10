package com.dev.eficiente.loja.dto;

import com.dev.eficiente.loja.dto.validators.Document;
import com.dev.eficiente.loja.dto.validators.ExistsId;
import com.dev.eficiente.loja.entity.Country;
import com.dev.eficiente.loja.entity.State;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NoLoginPaymentDTO {
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    private final String name;

    private @NotBlank
    final String surname;
    @Document
    private @NotBlank
    final String document;

    private @NotBlank
    final String address;

    private @NotBlank
    final String plusAddress;

    private @NotBlank
    final String city;
    @ExistsId(domainClass = Country.class, fieldName = "id")
    private @NotNull
    final Long countryId;
    @ExistsId(domainClass = State.class, fieldName = "id")
    private final Long stateId;

    private @NotBlank
    final String phone;

    private @NotBlank
    final String zipCode;

    public NoLoginPaymentDTO(String email, String name, String surname, String document, String address, String plusAddress, String city, Long countryId, Long stateId, String phone, String zipCode) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.plusAddress = plusAddress;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phone = phone;
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getPlusAddress() {
        return plusAddress;
    }

    public String getCity() {
        return city;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "NoLoginPaymentDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", plusAddress='" + plusAddress + '\'' +
                ", city='" + city + '\'' +
                ", countryId='" + countryId + '\'' +
                ", stateId='" + stateId + '\'' +
                ", phone='" + phone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
