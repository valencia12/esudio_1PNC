package com.uca.capas.mundo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_contribuyente")
	private Integer id_contribuyente;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;

	@Size(message = "El campo no debe contener mas de 30 caracteres", max = 30)
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="s_nombre")
	private String nombre;

	@Size(message = "El campo no debe contener mas de 30 caracteres", max = 30)
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="s_apellido")
	private String apellido;

	@Size(message = "El campo no debe contener mas de 14 caracteres", max = 14)
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="s_nit")
	private String nit;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="f_fecha_ingreso")
	private Date fIngreso;

	
	public Contribuyente() {}
	
	public Importancia getImportancia() {
		
		return importancia;
	}
	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
		
	}
	
	public Integer getId_contribuyente() {
		return id_contribuyente;
	}
	public void setId_contribuyente(Integer id_contribuyente) {
		this.id_contribuyente = id_contribuyente;
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
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getfIngreso(){

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String strFecha = formato.format(fIngreso);

		return strFecha;

	}
	public void setfIngreso(Date fIngreso) {
		this.fIngreso = fIngreso;
	}
	
	
	
	

}
