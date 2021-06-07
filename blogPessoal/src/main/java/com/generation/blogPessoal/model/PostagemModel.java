package com.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name="tb_postagem")
//table java, dentro do banco de dados, vai virar uma tabela (tabela postagens)

public class PostagemModel 
{
	//Model/Entity – classe responsável pela abstração dos recursos e objetos;
	//Obs: todas essas anotações @ servem para construir uma tabela
	
	//atributos
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		//este atributo sera uma primary key no banco de dados
		private long id;
		
		@NotNull
		@Size(min=5, max=100)
		private String titulo;
		
		@NotNull
		@Size(min=5, max=500)
		private String texto;
		
		@Temporal(TemporalType.TIMESTAMP)
		private Date data = new java.sql.Date(System.currentTimeMillis());
		
		@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Tema tema;
		
	//encapsulamento
		public long getId() 
		{
			return id;
		}
		
		public void setId(long id) 
		{
			this.id = id;
		}
		
		public String getTitulo() 
		{
			return titulo;
		}
		
		public void setTitulo(String titulo) 
		{
			this.titulo = titulo;
		}
		
		public String getTexto() 
		{
			return texto;
		}
		
		public void setTexto(String texto) 
		{
			this.texto = texto;
		}
		
		public Date getData() 
		{
			return data;
		}
		
		public void setData(Date data) 
		{
			this.data = data;
		}

		public Tema getTema() 
		{
			return tema;
		}

		public void setTema(Tema tema) 
		{
			this.tema = tema;
		}
		
		

}
