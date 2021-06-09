package com.generation.blogPessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

//configurar a segurança da aplicação
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailService);
	}
	
	//anotação mais basica do Spring, um metodo produz um bean para ser gerenciado pelo Spring
	@Bean 
	public PasswordEncoder passwordEncoder ()
	{
		return new BCryptPasswordEncoder ();
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/usuarios/logar").permitAll()
		.antMatchers("/usuarios/cadastrar").permitAll()
		.antMatchers("/tema").permitAll() //fiz pra testar 
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement()
		// não guarda sessao, nem dados privados
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		//cors , o que é ?  configurar acesso externo, quem pode acessar , o que pode acessar
		.and().csrf().disable();
		//csrf: prevenção de ataque hacker
	}
	//security

}
