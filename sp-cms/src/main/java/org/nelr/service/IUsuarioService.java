package org.nelr.service;

import java.util.List;

import org.nelr.model.entity.UsuarioEntity;
import org.nelr.model.exception.BasicSpcException;
import org.nelr.model.web.MensajeErrorDTO;
import org.nelr.model.web.UsuarioRegistroDTO;

public interface IUsuarioService {

	UsuarioEntity findByUserName(String userName);
	UsuarioEntity findByEmail(String email);
	
	List<MensajeErrorDTO> validateUserRegister(UsuarioRegistroDTO usuarioRegistroDto);
	void registerUser(UsuarioRegistroDTO usuarioRegistroDTO) throws BasicSpcException;
	
}
