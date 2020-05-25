package com.uca.capas.mundo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.mundo.domain.Contribuyente;
import com.uca.capas.mundo.domain.Importancia;
@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{
	 @PersistenceContext(unitName = "capas")
	 private EntityManager entityManager;
	
	
	@Override
	public List<Importancia> allImportancias() throws DataAccessException {
		
		StringBuffer sb = new StringBuffer();
	     sb.append("select * from public.importancia");
	     Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
	     List<Importancia> importanciaList = query.getResultList();
	     
	     return importanciaList;
		
	}
	
	

}
