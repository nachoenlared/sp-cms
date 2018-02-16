package org.nelr.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long id;
	
	@Column(name="userName", length=20)
	private String userName;
	
	@Column(name="pasword", length=50)
	private String password;
	
	@Column(name="email", length=200)
	private String email;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="usuarioEntity")
	private List<UsuarioPrivilegioEntity> listaUsuarioPrivilegioEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UsuarioPrivilegioEntity> getListaUsuarioPrivilegioEntity() {
		return listaUsuarioPrivilegioEntity;
	}

	public void setListaUsuarioPrivilegioEntity(List<UsuarioPrivilegioEntity> listaUsuarioPrivilegioEntity) {
		this.listaUsuarioPrivilegioEntity = listaUsuarioPrivilegioEntity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
