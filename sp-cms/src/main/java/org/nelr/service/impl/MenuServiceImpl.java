package org.nelr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.nelr.model.entity.MenuEntity;
import org.nelr.model.web.MenuDto;
import org.nelr.repository.MenuRepository;
import org.nelr.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuServiceImpl implements IMenuService{

	@Autowired
	MenuRepository menuRepository;
	
	public List<MenuDto> findMenuByUsuario(String userName){
		List<MenuDto> listaMenuDto = new ArrayList<MenuDto>();
		List<MenuEntity> listaMenuEntity = menuRepository.findMenuByUserName(userName);
		for(MenuEntity menuEntity : listaMenuEntity){
			MenuDto menuDto = new MenuDto();
			menuDto.setDescripcion(menuEntity.getDescripcion());
			menuDto.setVinculo(menuEntity.getVinculo());
			if(menuEntity.getListaMenusHijos()!=null && !menuEntity.getListaMenusHijos().isEmpty()){
				for(MenuEntity subMenuEntity : menuEntity.getListaMenusHijos()){
					MenuDto subMenuDto = new MenuDto();
					subMenuDto.setDescripcion(subMenuEntity.getDescripcion());
					subMenuDto.setVinculo(subMenuEntity.getVinculo());
					menuDto.getListaMenuHijos().add(subMenuDto);
				}
			}
			listaMenuDto.add(menuDto);
		}
		return listaMenuDto;
	}
	
	public List<MenuDto> findMenuByPrivilegio(String privilegio){
		List<MenuDto> listaMenuDto = new ArrayList<MenuDto>();
		List<MenuEntity> listaMenuEntity = menuRepository.findMenuByPrivilegio(privilegio);
		for(MenuEntity menuEntity : listaMenuEntity){
			MenuDto menuDto = new MenuDto();
			menuDto.setDescripcion(menuEntity.getDescripcion());
			menuDto.setVinculo(menuEntity.getVinculo());
			listaMenuDto.add(menuDto);
		}
		return listaMenuDto;
	}

}
