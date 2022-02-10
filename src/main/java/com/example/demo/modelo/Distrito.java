package com.example.demo.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name ="distrito")
public class Distrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="cod_postal")
	private String codPostal;
	
	@Column
	private String nomDis;
	
	@Column
	private String estadoDis;
	

	@OneToMany(mappedBy = "distrito")
	@JsonBackReference (value="itemcliente") //cortoBucle
	private Collection<Cliente> itemcliente = new ArrayList<Cliente>();
	
	

	public Distrito() {
		super();
	}

	


	public Distrito(String codPostal, String nomDis, String estadoDis) {
		super();
		this.codPostal = codPostal;
		this.nomDis = nomDis;
		this.estadoDis = estadoDis;
	}


	public Distrito(String codPostal, String nomDis, String estadoDis, Collection<Cliente> itemcliente) {
		super();
		this.codPostal = codPostal;
		this.nomDis = nomDis;
		this.estadoDis = estadoDis;
		this.itemcliente = itemcliente;
	}


	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getNomDis() {
		return nomDis;
	}

	public void setNomDis(String nomDis) {
		this.nomDis = nomDis;
	}

	public String getEstadoDis() {
		return estadoDis;
	}

	public void setEstadoDis(String estadoDis) {
		this.estadoDis = estadoDis;
	}

	public Collection<Cliente> getItemUsu() {
		return itemcliente;
	}

	public void setItemUsu(Collection<Cliente> itemcliente) {
		this.itemcliente = itemcliente;
	}
	
	


	
	
}
