package com.example.demo.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="cod_rol")
	private String codRol;
	
	@Column
	private String nomRol;
	
	@Column
	private String estado;
	
	//one to Many - entity stronge
	
	/*
	@OneToMany(mappedBy = "rol", cascade = CascadeType.REMOVE)
	@JsonBackReference(value = "itemUser")
	private Collection<Usuario> itemUser = new ArrayList<Usuario>();
	
	*/
	
	/*
	@ManyToOne
	@JoinColumn(name =" cod_usu",
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(cod_usu) references usuario (cod_usu)"))	
	
	
	private Usuario usuario;
	*/
	
	

	public Rol() {
		super();
	}
	
	

	public Rol(String codRol, String nomRol, String estado) {
		super();
		this.codRol = codRol;
		this.nomRol = nomRol;
		this.estado = estado;
	}


	public String getCodRol() {
		return codRol;
	}

	public void setCodRol(String codRol) {
		this.codRol = codRol;
	}

	public String getNomRol() {
		return nomRol;
	}

	public void setNomRol(String nomRol) {
		this.nomRol = nomRol;
	}
	

	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}


/*
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

*/





	

	
	

	
	
	
	
}
