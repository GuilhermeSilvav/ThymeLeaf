package com.senai.ThymeLeaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senai.ThymeLeaf.dtos.ContatoDto;
import com.senai.ThymeLeaf.services.ContatoService;

@Controller
@RequestMapping("/cadastrarcontatos")
public class CadastrarContatosController {

	ContatoService contatoService;

	@GetMapping()
	public String cadastrarContato(Model model) {

		ContatoDto contato = new ContatoDto();

		model.addAttribute("contatoDto", contato);
		return "cadastrarcontatos";

	}


}
