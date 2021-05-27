package com.generation.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogPessoal.model.PostagemModel;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long>
{
	//interface é um contrato
	//Repository – classe responsável pela comunicação com o banco de dados 
	//(manipulação de dados); (select)
	
	//find all buscar todos pelo titulo (atributo entidade)
	//containing = like caracteres digitados
	//ignore : não leva em consideração maiusculo e minusculo no titulo
	public List<PostagemModel> findAllByTituloContainingIgnoreCase (String titulo);

}
