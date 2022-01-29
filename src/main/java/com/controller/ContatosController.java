package com.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domain.Contatos;
import com.dto.ContatosDTO;
import com.services.ContatosService;

@Controller
@RequestMapping(value = "/contatos")
@CrossOrigin("*")
public class ContatosController {
	
	@Autowired
	private ContatosService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contatos> findById(@PathVariable Integer id) {
		Contatos contatos = service.findById(id);
		return ResponseEntity.ok().body(contatos);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<ContatosDTO>> findAll(){
		List<Contatos> list = service.findAll();
		List<ContatosDTO> listDTO = list.stream().map(obj -> new ContatosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping(value = "/") 
	public ResponseEntity<Contatos> create(@Valid @RequestBody Contatos contatos) {
		 contatos = service.create(contatos);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contatos.getId()).toUri();
		 return ResponseEntity.created(uri).body(contatos);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ContatosDTO> update(@Valid @PathVariable Integer id, @RequestBody ContatosDTO contatosDTO) {
		Contatos contatos = service.update(id, contatosDTO);
		return ResponseEntity.ok().body(new ContatosDTO(contatos));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
