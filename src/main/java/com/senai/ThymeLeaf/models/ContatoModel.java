package com.senai.ThymeLeaf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "contatos") // Nome da tabela no banco de dados
public class ContatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração de ID automático
    @Column(name = "id")  // Nome da coluna
    private Long id;

    @Column(name = "nome", nullable = false) // Nome da coluna e não pode ser nulo
    private String nome;

    @Column(name = "telefone", nullable = false) // Nome da coluna e não pode ser nulo
    private Double telefone; // Mantido como String

    @Column(name = "email", nullable = false) // Nome da coluna e não pode ser nulo
    private String email;

    @Column(name = "endereco", nullable = false) // Nome da coluna e não pode ser nulo
    private String endereco;

    @Column(name = "cpf_cnpj", nullable = false) // Nome da coluna e não pode ser nulo
    private String Cpf_cnpj; // Alterado para camelCase

    public ContatoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTelefone() {
        return telefone;
    }

    public void setTelefone(Double telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpfCnpj() {
        return Cpf_cnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.Cpf_cnpj = cpfCnpj;
    }

}
