package com.senai.ThymeLeaf.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senai.ThymeLeaf.dtos.CadastroDto;
import com.senai.ThymeLeaf.dtos.UsuarioDto;
import com.senai.ThymeLeaf.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping
    public String cadastrarUsuario(@ModelAttribute("usuario") CadastroDto cadastro) {
        boolean sucesso = usuarioService.cadastrarUsuario(cadastro);
        return sucesso ? "redirect:/listausuarios" : "redirect:/cadastrarusuario?erro";
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirUsuario(@PathVariable Long id) {
        boolean sucesso = usuarioService.excluirUsuario(id);
        return sucesso ? ResponseEntity.ok("Usuário excluído com sucesso.")
                       : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir usuário.");
    }
    
    
}
