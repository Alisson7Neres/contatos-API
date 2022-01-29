package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Contatos;
import com.domain.Numeros;
import com.dto.NumerosDTO;
import com.exceptions.ObjectNotFoundException;
import com.repository.NumerosRepository;

@Service
public class NumerosServices {
	
	@Autowired
	private NumerosRepository repository;
	
	@Autowired
	private ContatosService service;
	
	public Numeros findById(Integer id) {
		Optional<Numeros> obj = repository.findById(id);
		return obj.orElseThrow((() -> new ObjectNotFoundException(
				"Número não encontrado! id: " + id + ", contato: " + Contatos.class.getName())));
	}
	
	public List<Numeros> findAll(Integer contatos_join) {
		service.findById(contatos_join);
		return repository.findAllContatos(contatos_join);
	}
	
	public Numeros create(Integer contatos_join, Numeros obj) {
		obj.setId(null);
		Contatos contatos = service.findById(contatos_join);
		obj.setContatos(contatos);
		
		return repository.save(obj);
	}
	
	public Numeros update(Integer id, Numeros numeros) {
		Numeros numero = findById(id);
		numero.setNumero(numeros.getNumero());
		return repository.save(numero);
	}
	
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

}
