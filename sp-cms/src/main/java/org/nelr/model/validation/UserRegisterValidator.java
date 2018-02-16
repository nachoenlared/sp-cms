package org.nelr.model.validation;

import org.nelr.model.web.UsuarioRegistroDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserRegisterValidator implements Validator{
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UsuarioRegistroDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		UsuarioRegistroDTO usuarioRegistroDto = (UsuarioRegistroDTO) target;
		
		//check the username and password minimal requs
		if(!(usuarioRegistroDto.getEmail().length()>=5) || !(usuarioRegistroDto.getEmail().length()<=200)){
			errors.reject("email", "email.length");
		}
		
		if(!(usuarioRegistroDto.getUserName().length()>=4) || !(usuarioRegistroDto.getUserName().length()<=20)){
			errors.reject("username", "username.length");
		}
		
		if(!(usuarioRegistroDto.getPassword().length()>=8) || !(usuarioRegistroDto.getPassword().length()<=30)){
			errors.reject("password", "password.length");
		}
		
	}

}
