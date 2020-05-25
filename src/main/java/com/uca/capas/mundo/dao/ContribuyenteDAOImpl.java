package com.uca.capas.mundo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.mundo.domain.Contribuyente;


@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {
	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	
	@Override
	public List<Contribuyente> findAllContribuyentes() throws DataAccessException {
		// TODO Auto-generated method stub
		 StringBuffer sb = new StringBuffer();
	     sb.append("select * from public.contribuyente");
	     Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
	     List<Contribuyente> listaContribuyentes = query.getResultList();
	     
	     return listaContribuyentes;
	}

	@Override
	@Transactional
	public void insertarContribuyente(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		
		try {
			if(contribuyente.getId_contribuyente() == null) {
				entityManager.persist(contribuyente);
			}else {
				entityManager.merge(contribuyente);
				entityManager.flush();	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
