package org.nelr.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class MenuEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="vinculo")
	private String vinculo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="menuEntity")
	private List<MenuPrivilegioEntity> listaMenuPrivilegioEntity;

	@Column(name="orden")
	private Integer orden;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_padre_id")
	private MenuEntity menuPadre;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="menuPadre")
	private List<MenuEntity> listaMenusHijos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<MenuPrivilegioEntity> getListaMenuPrivilegioEntity() {
		return listaMenuPrivilegioEntity;
	}

	public void setListaMenuPrivilegioEntity(List<MenuPrivilegioEntity> listaMenuPrivilegioEntity) {
		this.listaMenuPrivilegioEntity = listaMenuPrivilegioEntity;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public MenuEntity getMenuPadre() {
		return menuPadre;
	}

	public void setMenuPadre(MenuEntity menuPadre) {
		this.menuPadre = menuPadre;
	}

	public List<MenuEntity> getListaMenusHijos() {
		return listaMenusHijos;
	}

	public void setListaMenusHijos(List<MenuEntity> listaMenusHijos) {
		this.listaMenusHijos = listaMenusHijos;
	}
	
}
