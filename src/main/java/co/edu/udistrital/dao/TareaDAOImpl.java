package co.edu.udistrital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.modelo.Tarea;

@Repository()
@Transactional
public class TareaDAOImpl implements TareaDAO{
	
	
	private static final String BASE_SELECT = "select tarea from Tarea tarea";
	@PersistenceContext
	public EntityManager entityManager;

	@Transactional(readOnly=false)
	public Tarea crear(Tarea tarea) {
		
		entityManager.persist(tarea);
		return tarea;
	}

	@Transactional(readOnly=false)
	public Tarea actualizar(Tarea tarea) {
		entityManager.merge(tarea);
		return tarea;
	}

	@Transactional(readOnly=false)
	public void borrar(long customerId) {
	
		
	}

	@Transactional(readOnly=true)
	public Tarea consultar(long id) {
		String sql = BASE_SELECT + " where tarea.id="+id;
		try{
			return (Tarea) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Tarea> consultar() {
		
		return entityManager.createQuery(BASE_SELECT).getResultList();
	}

	

}
