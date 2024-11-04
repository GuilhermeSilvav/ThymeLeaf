package com.senai.ThymeLeaf.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.ThymeLeaf.models.ContatoModel;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
    // Método que realiza o select no banco de dados filtrando no where o email do contato
    Optional<ContatoModel> findByEmail(String email);
}
