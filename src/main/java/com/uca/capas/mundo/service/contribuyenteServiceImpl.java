package com.uca.capas.mundo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.uca.capas.mundo.dao.ContribuyenteDAO;
import com.uca.capas.mundo.domain.Contribuyente;

@Service
public class contribuyenteServiceImpl implements contribuyenteService{
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;


	@Override
	public List<Contribuyente> findAllContribuyentes() throws DataAccessException {
		return contribuyenteDAO.findAllContribuyentes();
	}

	@Override
	@Transactional
	public void insertarContribuyente(Contribuyente contribuyente) throws DataAccessException {
		contribuyenteDAO.insertarContribuyente(contribuyente);
	
	}

}
