package org.nelr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.nelr.model.entity.UsuarioEntity;
import org.nelr.model.exception.BasicSpcException;
import org.nelr.model.web.MensajeErrorDTO;
import org.nelr.model.web.UsuarioRegistroDTO;
import org.nelr.repository.UsuarioPrivilegioRepository;
import org.nelr.repository.UsuarioRepository;
import org.nelr.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioPrivilegioRepository usuarioPrivilegioRepository;
	
	public UsuarioEntity findByUserName(String userName){
		return usuarioRepository.findByUserName(userName);
	}
	
	public UsuarioEntity findByEmail(String email){
		return usuarioRepository.findByEmail(email);
	}
	
	public List<MensajeErrorDTO> validateUserRegister(UsuarioRegistroDTO usuarioRegistroDto){
		
		List<MensajeErrorDTO> errors = new ArrayList<MensajeErrorDTO>();
		
		UsuarioEntity usuarioEntityAux = this.findByUserName(usuarioRegistroDto.getUserName());
		
		if(!(usuarioEntityAux==null)){
			errors.add(new MensajeErrorDTO("username", "username.exists"));
		}
		
		usuarioEntityAux = this.findByEmail(usuarioRegistroDto.getEmail());
		
		if(!(usuarioEntityAux==null)){
			errors.add(new MensajeErrorDTO("email", "email.exists"));
		}
		
		return errors;
	}
	
	public void registerUser(UsuarioRegistroDTO usuarioRegistroDTO) throws BasicSpcException{

		//encriptamos la passs y grabamos
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setUserName(usuarioRegistroDTO.getUserName());
		usuarioEntity.setEmail(usuarioRegistroDTO.getEmail());
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		usuarioEntity.setPassword(passwordEncoder.encode(usuarioRegistroDTO.getPassword()));
		
		usuarioRepository.save(usuarioEntity);
		
	}
	
}
