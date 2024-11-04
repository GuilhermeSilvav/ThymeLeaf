package com.senai.ThymeLeaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senai.ThymeLeaf.dtos.ContatoDto;
import com.senai.ThymeLeaf.services.ContatoService;

@Controller
@RequestMapping("/contatos")
public class ContatosController {

	  @Autowired
	  ContatoService contatoService;
	  
	@PostMapping
    public String cadastrarContatos(@ModelAttribute("contatos") ContatoDto cadastro) {
        boolean sucesso = contatoService.cadastrarContato(cadastro);
        return sucesso ? "redirect:/cadastrarcontatos" : "redirect:/cadastrarusuario?erro";
    }
}
