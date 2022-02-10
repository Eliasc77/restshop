package com.example.demo.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.modelo.Rol;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usu")
	private int codUsu;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROL", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROL_ID") })
	private Set<Rol> rol;

	@Column(name = "email", unique = true)
	private String email;

	@Column
	private String password;
	
	@OneToOne(mappedBy = "usuario")
	private Cliente cliente;
	


	public Usuario() {
		super();
	}

	public Usuario(int codUsu, Set<Rol> rol, String email, String password
			) {
		super();
		this.codUsu = codUsu;
		this.rol = rol;
		this.email = email;
		this.password = password;

	}

	

	public Usuario(int codUsu, Set<Rol> rol, String email, String password, Cliente cliente) {
		super();
		this.codUsu = codUsu;
		this.rol = rol;
		this.email = email;
		this.password = password;
		this.cliente = cliente;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}

	public Set<Rol> getRol() {
		return rol;
	}

	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
