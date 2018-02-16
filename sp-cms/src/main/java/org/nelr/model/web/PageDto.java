package org.nelr.model.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class PageDto {
	public String viewContentName;
	public String titleName;
	private List<MenuDto> listaMenuDto = new ArrayList<MenuDto>();
	private String baseUrl;
	private List<String> listaMensajeError;
	private List<String> listaMensajeExito;
	
	public PageDto(){
		
	}
	
	public PageDto(HttpServletRequest request){
		this.baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	}
	
	public String getViewContentName() {
		return viewContentName;
	}

	public void setViewContentName(String viewContentName) {
		this.viewContentName = viewContentName;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public List<MenuDto> getListaMenuDto() {
		return listaMenuDto;
	}

	public void setListaMenuDto(List<MenuDto> listaMenuDto) {
		this.listaMenuDto = listaMenuDto;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public List<String> getListaMensajeError() {
		return listaMensajeError;
	}

	public void setListaMensajeError(List<String> listaMensajeError) {
		this.listaMensajeError = listaMensajeError;
	}

	public List<String> getListaMensajeExito() {
		return listaMensajeExito;
	}

	public void setListaMensajeExito(List<String> listaMensajeExito) {
		this.listaMensajeExito = listaMensajeExito;
	}
	
}
