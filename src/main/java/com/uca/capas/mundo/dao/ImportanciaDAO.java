package com.uca.capas.mundo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.mundo.domain.Importancia;


public interface ImportanciaDAO {
	public List<Importancia> allImportancias() throws DataAccessException;

}
