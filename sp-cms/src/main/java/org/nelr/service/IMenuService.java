package org.nelr.service;

import java.util.List;

import org.nelr.model.web.MenuDto;

public interface IMenuService {

	List<MenuDto> findMenuByUsuario(String userName);
	
	List<MenuDto> findMenuByPrivilegio(String privilegio);
	
}
