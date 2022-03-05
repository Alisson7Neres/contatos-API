package com.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.domain.Contatos;
import com.domain.Numeros;
import com.repository.ContatosRepository;
import com.repository.NumerosRepository;

@Service
public class DBService implements ApplicationRunner {

	@Autowired
	private  ContatosRepository contatosRepository;
	
	@Autowired
	private  NumerosRepository numerosRepository;
	
	public void instaciaBaseDeDados() {

		Contatos conta1 = new Contatos(null, "Alisson", "Neres Ribeiro", "alisson.neres@hotmail.com");
		Numeros numero1 = new Numeros(null, "61999999999", conta1);

		conta1.getNumeros().addAll(Arrays.asList(numero1));
		
		this.contatosRepository.saveAll(Arrays.asList(conta1));
		this.numerosRepository.saveAll(Arrays.asList(numero1));
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.instaciaBaseDeDados();
	}

}
