package com.senai.ThymeLeaf.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senai.ThymeLeaf.dtos.UsuarioDto;
import com.senai.ThymeLeaf.services.UsuarioService;

@Controller
@RequestMapping("/atualizarusuario")
public class AtualizarController {
	@Autowired
    UsuarioService usuarioService;
	
	@GetMapping("/{id}")
    public String obterusuario(@PathVariable Long id, Model model) {
        Optional<UsuarioDto> usuario = usuarioService.obterUsuario(id);
        
        if (usuario.isPresent()) {
            model.addAttribute("usuarioDto", usuario.get());
            return "atualizarusuario";
        }
        
        return "redirect:/listausuarios";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute UsuarioDto usuarioDto) {
        boolean sucesso = usuarioService.atualizarUsuario(id, usuarioDto);
        return sucesso ? "redirect:/listausuarios" : "redirect:/visualizarusuario/" + id + "?erro";
    }
}
