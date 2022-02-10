package com.example.demo.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cod_pro")
	private int codPro;
	
	@Column
	private String nomPro;
	
	//cod categoria
	@ManyToOne
	@JoinColumn(name="cod_cate", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(cod_cate) references categoria (cod_cate)"))
	private Categoria categoria;
	

		
	@Column
	private Double precioUnit;
	
	@Column
	private String imgUrl;
	
	@Column
	private int stock;
	
	@Column
	private String estado;
	

	@Column
	private Boolean isOnSale;
	
	@Column
	private String description;
	
	
	@Column
	private int quantity;
	
	//detalle pedido
	@OneToMany(mappedBy = "producto")
	@JsonBackReference(value="itemDetalle")
	private Collection<DetallePedido> itemDetalle = new ArrayList<DetallePedido>();
	
	

	public Producto() {
		super();
	}
	
	

	public Producto(int codPro, String nomPro, Categoria categoria, Double precioUnit,
			int stock, String estado, Boolean isOnSale, String description, int quantity) {
		super();
		this.codPro = codPro;
		this.nomPro = nomPro;
		this.categoria = categoria;
		this.precioUnit = precioUnit;
		this.stock = stock;
		this.estado = estado;
		this.isOnSale = isOnSale;
		this.description = description;
		this.quantity = quantity;
	}

	public Producto(int codPro, String nomPro, Categoria categoria, Double precioUnit,
			int stock, String estado, Collection<DetallePedido> itemDetalle) {
		super();
		this.codPro = codPro;
		this.nomPro = nomPro;
		this.categoria = categoria;
		this.precioUnit = precioUnit;
		this.stock = stock;
		this.estado = estado;
		this.itemDetalle = itemDetalle;
		
		
	}
	
	

	public Producto(int codPro, String nomPro, Categoria categoria, Double precioUnit,
			String imgUrl, int stock, String estado) {
		super();
		this.codPro = codPro;
		this.nomPro = nomPro;
		this.categoria = categoria;

		this.precioUnit = precioUnit;
		this.imgUrl = imgUrl;
		this.stock = stock;
		this.estado = estado;
	}

	public int getCodPro() {
		return codPro;
	}

	public void setCodPro(int codPro) {
		this.codPro = codPro;
	}

	public String getNomPro() {
		return nomPro;
	}

	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getPrecioUnit() {
		return precioUnit;
	}

	public void setPrecioUnit(Double precioUnit) {
		this.precioUnit = precioUnit;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String isEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Collection<DetallePedido> getItemDetalle() {
		return itemDetalle;
	}

	public void setItemDetalle(Collection<DetallePedido> itemDetalle) {
		this.itemDetalle = itemDetalle;
	}

	public String getEstado() {
		return estado;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	public Boolean getIsOnSale() {
		return isOnSale;
	}



	public void setIsOnSale(Boolean isOnSale) {
		this.isOnSale = isOnSale;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
	
}
