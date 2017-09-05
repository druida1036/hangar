package co.edu.udistrital.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.modelo.entidades.Nave;

@Repository()
@Transactional
public class NaveDAOImpl implements NaveDAO{
	
	
	private static final String BASE_SELECT = "select nave from Nave nave";
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
	public void borrar(Nave nave) {
		entityManager.remove(consultar(nave.getId()));
		
	}

	@Transactional(readOnly=true)
	public Nave consultar(long id) {
		String sql = BASE_SELECT + " where nave.id="+id;
		try{
			Nave nave = (Nave) entityManager.createQuery(sql).getSingleResult();
			Hibernate.initialize(nave.getComponentes());
			return (Nave) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Nave> consultar() {
		
		return entityManager.createQuery(BASE_SELECT).getResultList();
	}

	

}
