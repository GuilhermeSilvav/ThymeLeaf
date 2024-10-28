package com.senai.ThymeLeaf.dtos;


public class UsuarioDto {
	
	private String nome;
    private Long id;
    
    public UsuarioDto() {
		super();
	}

	private String email;

	public Long getId() {
		return id;
	}
	public String getNome() {
        return nome;
    }


	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setNome(String nome) {
        this.nome = nome;
    }
    
}
