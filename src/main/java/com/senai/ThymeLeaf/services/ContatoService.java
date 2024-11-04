package com.senai.ThymeLeaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ThymeLeaf.dtos.ContatoDto;
import com.senai.ThymeLeaf.models.ContatoModel;
import com.senai.ThymeLeaf.repositories.ContatoRepository;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository; // Injeção de dependência

    public boolean cadastrarContato(ContatoDto cadastro) {
        if (contatoRepository.findByEmail(cadastro.getEmail()).isPresent()) {
            return false;
        }
        
        ContatoModel contato = new ContatoModel();
        
        contato.setNome(cadastro.getNome());
        contato.setTelefone(cadastro.getTelefone());
        contato.setEmail(cadastro.getEmail());
        contato.setEndereco(cadastro.getEndereco());
        contato.setCpfCnpj(cadastro.getCpf_cnpj());
        contatoRepository.save(contato);
        
        return true;
    }
    
}
