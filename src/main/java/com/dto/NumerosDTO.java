package com.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.domain.Numeros;

public class NumerosDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "ID NÃO GERADO!")
	private Integer id;
	
	@NotBlank(message = "Número precisa ser PREENCHIDO!")
	@Length(min = 10, max = 11)
	private String numero;
	
	// construtor padrão
	public NumerosDTO() {
		super();
	}
	
	// construtor declarado
	public NumerosDTO(Numeros obj) {
		super();
		this.id = obj.getId();
		this.numero = obj.getNumero();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
