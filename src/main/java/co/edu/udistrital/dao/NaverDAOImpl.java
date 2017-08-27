package co.edu.udistrital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.modelo.Nave;

@Repository()
@Transactional
public class NaverDAOImpl implements NaveDAO{
	
	
	private static final String BASE_SELECT = "select * from Nave nave";
	@PersistenceContext
	public EntityManager entityManager;

	@Transactional(readOnly=false)
	public Nave crear(Nave nave) {
		
		entityManager.persist(nave);
		return nave;
	}

	@Transactional(readOnly=false)
	public Nave actualizar(Nave nave) {
		entityManager.merge(nave);
		return nave;
	}

	@Transactional(readOnly=false)
	public void borrar(long customerId) {
	
		
	}

	@Transactional(readOnly=true)
	public Nave consulta(long id) {
		String sql = BASE_SELECT + " where nave.id="+id;
		try{
			return (Nave) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Nave> consulta() {
		
		return entityManager.createQuery(BASE_SELECT).getResultList();
	}

	

}
