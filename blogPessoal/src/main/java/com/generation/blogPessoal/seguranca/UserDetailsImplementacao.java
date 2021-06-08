package com.generation.blogPessoal.seguranca;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogPessoal.model.UsuarioModel;

//representa o user logado no sistema
public class UserDetailsImplementacao implements UserDetails
{
	//interno java
	private static final long SerialVersionUID = 1L;
	
	private String userName;
	private String password;
	private List<GrantedAuthority> authority;
	
	public UserDetailsImplementacao (UsuarioModel user)
	{
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	//pra que isso?
	public UserDetailsImplementacao ()
	{
		
	}

	@Override
	//objeto de autorização
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
