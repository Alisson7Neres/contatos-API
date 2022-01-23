package com.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.domain.Contatos;

public class ContatosDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Nome não pode ser vázio")
	@Length(min = 3, max = 20)
	private String nome;
	
	@NotEmpty(message = "Sobrenome não pode ser vázio")
	@Length(min = 3, max = 30)
	private String sobrenome;
	
	private String email;
	
	// Construtor padrão
	public ContatosDTO() {
		super();
	}
	
	// Construtor declarado
	
	public ContatosDTO(Contatos obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sobrenome = obj.getSobrenome();
		this.email = obj.getEmail();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
