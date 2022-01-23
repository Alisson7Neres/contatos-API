package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Contatos;
import com.dto.ContatosDTO;
import com.exceptions.ObjectNotFoundException;
import com.repository.ContatosRepository;

@Service
public class ContatosService {
	
	@Autowired
	private ContatosRepository repository;
	
	public Contatos findById(Integer id) {
		Optional<Contatos> obj = repository.findById(id);
		return obj.orElseThrow((() -> new ObjectNotFoundException(
				"Contato não encontrado! id: " + id + ", tipo " + Contatos.class.getName())));
	}
	
	public List<Contatos> findAll() {
		return repository.findAll();
	}
	
	public Contatos create(Contatos obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Contatos update(Integer id, ContatosDTO objDto) {
		Contatos obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setSobrenome(objDto.getSobrenome());
		obj.setEmail(objDto.getEmail());
		
		return repository.save(obj);
	}
	
	public void deletar(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

}
