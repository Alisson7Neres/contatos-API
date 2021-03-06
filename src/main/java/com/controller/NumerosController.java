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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domain.Numeros;
import com.dto.NumerosDTO;
import com.services.NumerosServices;

@Controller
@RequestMapping(value = "/numeros")
@CrossOrigin("*")
public class NumerosController {

	@Autowired
	private NumerosServices service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Numeros> findById(@PathVariable Integer id) {
		Numeros numeros = service.findById(id);
		return ResponseEntity.ok().body(numeros);
	}
	
	@GetMapping
	public ResponseEntity<List<NumerosDTO>> findAll(@RequestParam(value = "contatos", defaultValue = "0") Integer contatos_join) {
		List<Numeros> list = service.findAll(contatos_join);
		List<NumerosDTO> listDTO = list.stream().map(obj -> new NumerosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Numeros> create(@RequestParam(value = "contatos", defaultValue = "0")Integer contatos_join, @Valid @RequestBody Numeros obj) {
			Numeros numero = service.create(contatos_join, obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/numeros/{id}").buildAndExpand(numero.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Numeros> update(@PathVariable Integer id,@Valid @RequestBody Numeros numeros) {
		Numeros numero = service.update(id, numeros);
		return ResponseEntity.ok().body(numero);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
