package com.uca.capas.mundo.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.mundo.domain.Contribuyente;

public interface contribuyenteService {
	
	public List<Contribuyente> findAllContribuyentes() throws DataAccessException;
	
	public void insertarContribuyente(Contribuyente contribuyente) throws DataAccessException;


}
