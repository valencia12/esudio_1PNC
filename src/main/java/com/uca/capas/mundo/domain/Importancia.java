package com.uca.capas.mundo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="importancia")
public class Importancia {
	
	@Id
	@Column(name="c_importancia")
	private Integer id_importancia;
	
	@Column(name="s_importancia")
	private String s_importancia;
	
	@OneToMany(mappedBy="importancia",fetch= FetchType.EAGER)
	private List<Contribuyente> contribuyente;
	
	public Importancia() {}
	
	public Integer getId_importancia() {
		return id_importancia;
	}
	public void setId_importancia(Integer id_importancia) {
		this.id_importancia = id_importancia;
	}
	public String getS_importancia() {
		return s_importancia;
	}
	public void setS_importancia(String s_importancia) {
		this.s_importancia = s_importancia;
	}

	public List<Contribuyente> getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(List<Contribuyente> contribuyente) {
		this.contribuyente = contribuyente;
	}
	
	
	

}
