package org.nelr.core;

import java.util.ArrayList;
import java.util.List;

import org.nelr.model.entity.UsuarioEntity;
import org.nelr.model.entity.UsuarioPrivilegioEntity;
import org.nelr.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	IUsuarioService usuarioService;
	//CustomUserDetailsService userDetailsService;
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        //String message="Wrong Username or Password";
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        UsuarioEntity usuEntity = usuarioService.findByUserName(username);
        
        if(usuEntity != null && usuEntity.getUserName().equals(username) && passwordEncoder.matches(password, usuEntity.getPassword())){
        	for(UsuarioPrivilegioEntity usuarioPrivilegioEntity :usuEntity.getListaUsuarioPrivilegioEntity()){
        		authorities.add(new SimpleGrantedAuthority("ROLE_"+usuarioPrivilegioEntity.getPrivilegio()));
        	}
        }else{
        	throw new AuthenticationCredentialsNotFoundException("User not found");
        }
		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
