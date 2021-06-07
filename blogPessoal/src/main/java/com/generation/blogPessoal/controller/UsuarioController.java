package com.generation.blogPessoal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.model.UserLoginModel;
import com.generation.blogPessoal.model.UsuarioModel;
import com.generation.blogPessoal.service.UsuarioService;

@RestController
@RequestMapping ("usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController 
{
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<UserLoginModel> Autentication (@RequestBody Optional<UserLoginModel> user)
	{
		return usuarioService.Logar(user).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping ("/cadastrar")
	public ResponseEntity<UsuarioModel> Post (@RequestBody UsuarioModel usuario)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}

}
