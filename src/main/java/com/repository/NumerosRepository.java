package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.domain.Numeros;

@Repository
public interface NumerosRepository extends JpaRepository<Numeros, Integer>{

	@Query("SELECT obj FROM Numeros obj WHERE obj.contatos.id = :contatos_join")
	List<Numeros> findAllContatos(@Param (value = "contatos_join")Integer contatos_foreing);

}
