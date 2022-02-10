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

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="cod_cate")
	private String codCate;
	
	@Column
	private String nomCate;
	
	@Column
	private String estadoCate;
	
	@Column
	private String imgUrl;
	
	
	@OneToMany(mappedBy = "categoria")
	@JsonBackReference
	private Collection<Producto> itemProduct = new ArrayList<Producto>();


	public Categoria() {
		super();
	}

	public Categoria(String codCate, String nomCate, String estadoCate, String imgUrl) {
		super();
		this.codCate = codCate;
		this.nomCate = nomCate;
		this.estadoCate = estadoCate;
		this.imgUrl = imgUrl;
	}


	public Categoria(String codCate, String nomCate, String estadoCate, Collection<Producto> itemProduct) {
		super();
		this.codCate = codCate;
		this.nomCate = nomCate;
		this.estadoCate = estadoCate;
		this.itemProduct = itemProduct;
	}

	



	public String getCodCate() {
		return codCate;
	}


	public void setCodCate(String codCate) {
		this.codCate = codCate;
	}


	public String getNomCate() {
		return nomCate;
	}


	public void setNomCate(String nomCate) {
		this.nomCate = nomCate;
	}


	public String getEstadoCate() {
		return estadoCate;
	}


	public void setEstadoCate(String estadoCate) {
		this.estadoCate = estadoCate;
	}


	public Collection<Producto> getItemProduct() {
		return itemProduct;
	}


	public void setItemProduct(Collection<Producto> itemProduct) {
		this.itemProduct = itemProduct;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
	
	

}
