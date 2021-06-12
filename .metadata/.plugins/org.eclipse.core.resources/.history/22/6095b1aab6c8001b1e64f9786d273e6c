package com.generation.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.generation.blogPessoal.model.UserLoginModel;
import com.generation.blogPessoal.model.UsuarioModel;
import com.generation.blogPessoal.repository.UsuarioRepository;

@Service
//regra de negocio
public class UsuarioService 
{
	@Autowired
	private UsuarioRepository repository;
	
	public UsuarioModel CadastrarUsuario (UsuarioModel usuario)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		
		usuario.setSenha(senhaEncoder);
		
		return repository.save(usuario);
	}
	
	public Optional<UserLoginModel> Logar (Optional<UserLoginModel> user)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<UsuarioModel> usuario = repository.findByUsuario(user.get().getUsuario());
		//verifica se o usuario ja existe no banco de dados
		//usuario banco de dados
		if (usuario.isPresent())
		{
			//user json
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha()))
			{
				//token criado aqui
				//pega a string e transforma em bytes
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				
				//token completo
				String authHeader = "Basic " + new String (encodedAuth);
				
				//token completo
				user.get().setToken(authHeader);
				//usuario banco de dados
				user.get().setNome(usuario.get().getNome());
				
				
				return user;
			}
		}
		
		//return null;
		return Optional.empty();
		
	}
}
