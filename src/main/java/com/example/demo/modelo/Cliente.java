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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name ="cliente")
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="cod_cli")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column
	private String nombres;

	@Column
	private String apellidos;

	@Column(length = 8, unique = true)
	private String dni;

	// distrito - many to one
	@ManyToOne
	@JoinColumn(name = "cod_postal", 
		foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (cod_postal) references distrito (cod_postal)"))
	private Distrito distrito;

	@Column
	private String direccion;

	@Column
	private String telefono;
	
	@Column
	private String imageUrl;

	@OneToMany(mappedBy = "cliente")
	@JsonBackReference(value = "itemOrdenP")
	private Collection<OrdenPedido> itemOrdenP = new ArrayList<OrdenPedido>();
	
	
	@OneToOne
	@JoinColumn(name="cod_usu", nullable = false, unique = true,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(cod_usu) references usuario(cod_usu)"))
	@JsonBackReference
	private Usuario usuario;
	


	public Cliente(int codigo, String nombres, String apellidos, String dni, Distrito distrito, String direccion,
			String telefono, String imageUrl) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.distrito = distrito;
		this.direccion = direccion;
		this.telefono = telefono;
		this.imageUrl = imageUrl;
	}

	
	public Cliente(int codigo, String nombres, String apellidos, String dni, Distrito distrito, String direccion,
			String telefono, String imageUrl, Collection<OrdenPedido> itemOrdenP, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.distrito = distrito;
		this.direccion = direccion;
		this.telefono = telefono;
		this.imageUrl = imageUrl;
		this.itemOrdenP = itemOrdenP;
		this.usuario = usuario;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Collection<OrdenPedido> getItemOrdenP() {
		return itemOrdenP;
	}

	public void setItemOrdenP(Collection<OrdenPedido> itemOrdenP) {
		this.itemOrdenP = itemOrdenP;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
