package com.cibertec.edu.pe.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import java.text.ParseException;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	@Column(name="nombre",nullable = false,length = 45)
	private String nombre;
	@Column(name="apellido",nullable = false,length = 45)
	private String apellido;
	@Email
	@Column(name="correo",nullable = false,length = 45 ,unique = true)
	private String correo;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fnacimiento;
	@Column(name="dni",nullable = false,length = 8)
	private String dni;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Categoria categoria;

	public Cliente() {
	}

	public Cliente(int idCliente, String nombre, String apellido, @Email String correo, Date fnacimiento, String dni,
			Categoria categoria) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fnacimiento = fnacimiento;
		this.dni = dni;
		this.categoria = categoria;
	}
	public Cliente(String nombre, String apellido, @Email String correo, String fnacimiento, String dni,
			Categoria categoria) throws ParseException {		
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fnacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fnacimiento);
		this.dni = dni;
		this.categoria = categoria;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFnacimiento() {
		return new SimpleDateFormat("yyyy-MM-dd").format(fnacimiento);
	}

	public void setFnacimiento(Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
