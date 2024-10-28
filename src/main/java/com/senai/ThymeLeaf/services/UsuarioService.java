package com.senai.ThymeLeaf.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ThymeLeaf.dtos.CadastroDto;
import com.senai.ThymeLeaf.dtos.LoginDto;
import com.senai.ThymeLeaf.dtos.UsuarioDto;
import com.senai.ThymeLeaf.models.UsuarioModel;
import com.senai.ThymeLeaf.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
        
    public boolean validarLogin(LoginDto loginDto) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findByEmail(loginDto.getEmail());
        
        if (!optionalUsuario.isPresent() || !optionalUsuario.get().getSenha().equals(loginDto.getSenha())) {
            return false;
        }        
        
        return true;
    }
    
    public List<UsuarioDto> obterListaUsuarios() {
        List<UsuarioModel> listaUsuarioModel = usuarioRepository.findAll();
        List<UsuarioDto> listaUsuario = new ArrayList<>();
        
        for (UsuarioModel usuario : listaUsuarioModel) {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setEmail(usuario.getEmail());
            listaUsuario.add(usuarioDto);
        }
        
        return listaUsuario;
    }
    
    public boolean cadastrarUsuario(CadastroDto cadastro) {
        if (usuarioRepository.findByEmail(cadastro.getEmail()).isPresent()) {
            return false;
        }
        
        UsuarioModel usuario = new UsuarioModel();
        usuario.setEmail(cadastro.getEmail());
        usuario.setSenha(cadastro.getSenha());
        
        usuarioRepository.save(usuario);
        
        return true;
    }
    
    public boolean excluirUsuario(Long id) {
        if (!usuarioRepository.findById(id).isPresent()) {
            return false;
        }
        
        usuarioRepository.deleteById(id);
        
        return true;
    }
    
    public Optional<UsuarioDto> obterUsuario(Long id) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);
        
        if (optionalUsuario.isPresent()) {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(optionalUsuario.get().getId());
            usuarioDto.setEmail(optionalUsuario.get().getEmail());
            return Optional.of(usuarioDto);
        }
        
        return Optional.empty();
    }

    public boolean atualizarUsuario(Long id, UsuarioDto usuarioDto) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);
        
        if (!optionalUsuario.isPresent()) {
            return false;
        }

        UsuarioModel usuario = optionalUsuario.get();
        usuario.setEmail(usuarioDto.getEmail());
        usuarioRepository.save(usuario);
        
        return true;
    }
}
