package com.example.demo.modelo;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.Table;

@Entity
@Table(name="detalle_pedido")
public class DetallePedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "num_pedido",
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(num_pedido) references orden_pedido(num_pedido)"))
	private OrdenPedido ordenpedido;
	
	
	@ManyToOne
	@JoinColumn(name  = "cod_pro",
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(cod_pro) references producto (cod_pro)"))
	private Producto producto;
	
	@Column
	private int cantidad;
	
	@Column
	private int precioUnit;
	
	@Column
	private double subtotal;
	
	


	public DetallePedido() {
		super();
	}




	public DetallePedido(int id, OrdenPedido ordenpedido, Producto producto, int cantidad, int precioUnit,
			double subtotal) {
		super();
		this.id = id;
		this.ordenpedido = ordenpedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnit = precioUnit;
		this.subtotal = subtotal;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public OrdenPedido getOrdenpedido() {
		return ordenpedido;
	}




	public void setOrdenpedido(OrdenPedido ordenpedido) {
		this.ordenpedido = ordenpedido;
	}




	public Producto getProducto() {
		return producto;
	}




	public void setProducto(Producto producto) {
		this.producto = producto;
	}




	public int getCantidad() {
		return cantidad;
	}




	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}




	public int getPrecioUnit() {
		return precioUnit;
	}




	public void setPrecioUnit(int precioUnit) {
		this.precioUnit = precioUnit;
	}




	public double getSubtotal() {
		return subtotal;
	}




	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	

	


	
	
	

}
