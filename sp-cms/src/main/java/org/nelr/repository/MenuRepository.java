package org.nelr.repository;

import java.util.List;

import org.nelr.model.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<MenuEntity,Long> {

	@Query("SELECT m from MenuEntity m, MenuPrivilegioEntity mp, UsuarioPrivilegioEntity up, UsuarioEntity u where m.id = mp.menuEntity.id and mp.privilegio = up.privilegio and up.usuarioEntity.id = u.id and u.userName = ?1 and m.menuPadre is null order by m.orden asc")
	public List<MenuEntity> findMenuByUserName(String userName);
	
	@Query("SELECT m from MenuEntity m, MenuPrivilegioEntity mp where m.id = mp.menuEntity.id and mp.privilegio  = ?1 and m.menuPadre is not null order by m.orden asc")
	public List<MenuEntity> findMenuByPrivilegio(String privilegio);
	
}
