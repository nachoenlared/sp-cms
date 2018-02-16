package org.nelr.service.impl;

import org.nelr.model.entity.UsuarioEntity;
import org.nelr.model.entity.UsuarioPrivilegioEntity;
import org.nelr.repository.UsuarioPrivilegioRepository;
import org.nelr.service.IUsuarioPrivilegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioPrivilegioServiceImpl implements IUsuarioPrivilegioService{

	private final static String ROLE_USER = "USER";
	
	@Autowired
	UsuarioPrivilegioRepository usuarioPrivilegioRepository;
	
	public void addPrivilegeUser(UsuarioEntity usuarioEntity){
		UsuarioPrivilegioEntity usuarioPrivilegioEntity = new UsuarioPrivilegioEntity();
		usuarioPrivilegioEntity.setUsuarioEntity(usuarioEntity);
		usuarioPrivilegioEntity.setPrivilegio(ROLE_USER);
		
		usuarioPrivilegioRepository.save(usuarioPrivilegioEntity);
		
	}
	
}
