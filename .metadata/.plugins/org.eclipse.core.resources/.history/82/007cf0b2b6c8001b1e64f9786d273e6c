package com.generation.blogPessoal.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.blogPessoal.model.UsuarioModel;
import com.generation.blogPessoal.repository.UsuarioRepository;

@Service

public class UserDetailsServiceImplementacao implements UserDetailsService
{
	@Autowired
	private UsuarioRepository userRepository;
	
	                                                       //throws ? tipos de exceção
	@Override
	public UserDetails loadUserByUsername (String userName) throws UsernameNotFoundException
	{
		// |    |  
		Optional<UsuarioModel> user = userRepository.findByUsuario(userName);
		
		user.orElseThrow(()-> new UsernameNotFoundException(userName + "not found.") );
		
		//sempre que for chamar algum metodo que recebe ele mesmo como parametro, da pra fazer assim
		return user.map(UserDetailsImplementacao::new).get(); //method reference :: variação da expressão lambda
		
		//return user.map (user -> new UserDetailsImplementacao(user)).get();
	}
}
