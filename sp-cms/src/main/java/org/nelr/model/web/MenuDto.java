package org.nelr.model.web;

import java.util.ArrayList;
import java.util.List;

public class MenuDto {

	private String descripcion;
	private String vinculo;
	private List<MenuDto> listaMenuHijos = new ArrayList<MenuDto>();
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getVinculo() {
		return vinculo;
	}
	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}
	public List<MenuDto> getListaMenuHijos() {
		return listaMenuHijos;
	}
	public void setListaMenuHijos(List<MenuDto> listaMenuHijos) {
		this.listaMenuHijos = listaMenuHijos;
	}
	
}
