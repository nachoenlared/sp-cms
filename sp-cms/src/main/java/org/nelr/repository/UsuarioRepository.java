package org.nelr.repository;

import org.nelr.model.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	UsuarioEntity findByUserName(String userName);
	UsuarioEntity findByEmail(String email);
	
}
