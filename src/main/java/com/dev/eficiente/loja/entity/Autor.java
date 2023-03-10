package com.dev.eficiente.loja.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String name;
    @Email
    @Column(unique = true)
    @Size(max = 100)
    private String email;
    @NotBlank
    @Size(max = 400)
    private String description;
    @CreationTimestamp
    private Timestamp createdAt;

    @Deprecated
    public Autor() {
    }

    public Autor(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Autor(String email) {
        this.email = email;
    }

    public Autor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
