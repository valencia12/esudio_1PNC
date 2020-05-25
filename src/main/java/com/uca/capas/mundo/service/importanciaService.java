package com.uca.capas.mundo.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.mundo.domain.Importancia;

public interface importanciaService {
	
	public List<Importancia> allImportancias() throws DataAccessException;

}
