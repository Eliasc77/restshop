package com.example.demo.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orden_pedido")
public class OrdenPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="num_pedido")
	private int numPedido;
	
	@Temporal(TemporalType.DATE)
	private Date fechaEmi;
	
	//cliente
	@ManyToOne
	@JoinColumn(name ="cod_cli",
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (cod_cli) references cliente(cod_cli)"))
	private Cliente cliente;

	
	
	@Column
	private Double total;
	
	@Column
	private boolean estadoOrdenP;
	
	
	@OneToMany(mappedBy = "ordenpedido")
	@JsonBackReference(value="itemDetallep")
	private Collection<DetallePedido> itemDetallep = new ArrayList<DetallePedido>();
	
	
	@OneToOne(mappedBy = "ordenPedido")
	@JsonBackReference(value="comprobantePago")
	private ComprobantePago comprobantePago;
	
	

	public OrdenPedido() {
		super();
	}


	public OrdenPedido(int numPedido, Date fechaEmi, Cliente cliente, Double total, boolean estadoOrdenP) {
		super();
		this.numPedido = numPedido;
		this.fechaEmi = fechaEmi;
		this.cliente = cliente;
		this.total = total;
		this.estadoOrdenP = estadoOrdenP;
	}

	public OrdenPedido(int numPedido, Date fechaEmi, Cliente cliente, Double total, boolean estadoOrdenP,
			Collection<DetallePedido> itemDetallep, ComprobantePago comprobantePago) {
		super();
		this.numPedido = numPedido;
		this.fechaEmi = fechaEmi;
		this.cliente = cliente;
		this.total = total;
		this.estadoOrdenP = estadoOrdenP;
		this.itemDetallep = itemDetallep;
		this.comprobantePago = comprobantePago;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public Date getFechaEmi() {
		return fechaEmi;
	}

	public void setFechaEmi(Date fechaEmi) {
		this.fechaEmi = fechaEmi;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public boolean isEstadoOrdenP() {
		return estadoOrdenP;
	}

	public void setEstadoOrdenP(boolean estadoOrdenP) {
		this.estadoOrdenP = estadoOrdenP;
	}
	
	@PrePersist
	public void prePersit()
	{
		this.fechaEmi = new Date();
	}

	public Collection<DetallePedido> getItemDetallep() {
		return itemDetallep;
	}

	public void setItemDetallep(Collection<DetallePedido> itemDetallep) {
		this.itemDetallep = itemDetallep;
	}

	public ComprobantePago getComprobantePago() {
		return comprobantePago;
	}

	public void setComprobantePago(ComprobantePago comprobantePago) {
		this.comprobantePago = comprobantePago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
	
	
}
