package com.uca.capas.mundo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.mundo.dao.ImportanciaDAO;
import com.uca.capas.mundo.domain.Importancia;

@Service
public class importanciaServiceImpl implements importanciaService {

	@Autowired
	ImportanciaDAO importanciaDAO;
	
	@Override
	public List<Importancia> allImportancias() throws DataAccessException {
		return importanciaDAO.allImportancias();
	}

}
