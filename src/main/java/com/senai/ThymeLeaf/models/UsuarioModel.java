package com.senai.ThymeLeaf.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class UsuarioModel {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 90)
    private String email;

    @Column(name = "senha", nullable = false, length = 90)
    private String senha; 

    // Construtor padrão
    public UsuarioModel() {
    }

    // Construtor com parâmetros
    public UsuarioModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    // Getter e Setter para id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e Setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter e Setter para senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método toString para exibir o conteúdo do objeto
    @Override
    public String toString() {
        return "UsuarioModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
