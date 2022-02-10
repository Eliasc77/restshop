package com.example.demo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name ="comprobante_pago")
public class ComprobantePago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="comp_pago")
	private int compPago;
	

	
	@Column
	private String formaPago;
	
	@Column
	private String estadoComp;
	
	//numpedido
	@OneToOne
	@JoinColumn(name="num_pedido",unique = true,nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (num_pedido) references orden_pedido (num_pedido)"))
	private OrdenPedido ordenPedido;
	
	

	public ComprobantePago() {
		super();
	}



	public ComprobantePago(int compPago, String formaPago, String estadoComp, OrdenPedido ordenPedido) {
		super();
		this.compPago = compPago;
		this.formaPago = formaPago;
		this.estadoComp = estadoComp;
		this.ordenPedido = ordenPedido;
	}



	public int getCompPago() {
		return compPago;
	}



	public void setCompPago(int compPago) {
		this.compPago = compPago;
	}



	public String getFormaPago() {
		return formaPago;
	}



	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}



	public String getEstadoComp() {
		return estadoComp;
	}



	public void setEstadoComp(String estadoComp) {
		this.estadoComp = estadoComp;
	}



	public OrdenPedido getOrdenPedido() {
		return ordenPedido;
	}



	public void setOrdenPedido(OrdenPedido ordenPedido) {
		this.ordenPedido = ordenPedido;
	}

	
	
	
}
